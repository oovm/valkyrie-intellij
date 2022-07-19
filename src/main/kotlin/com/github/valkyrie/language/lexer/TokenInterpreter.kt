@file:OptIn(ExperimentalStdlibApi::class)

package com.github.valkyrie.language.lexer

import com.github.valkyrie.language.psi.ValkyrieTypes
import com.intellij.psi.TokenType.BAD_CHARACTER
import com.intellij.psi.TokenType.WHITE_SPACE

import com.intellij.psi.tree.IElementType

// @Suppress("MemberVisibilityCanBePrivate")
class TokenInterpreter(val buffer: CharSequence, var startOffset: Int, val endOffset: Int, var context: StackContext) {
    companion object {
        val EOL = "\\R".toRegex()
        val ROL = "[^\\r\\n]+".toRegex()
        val WS = "\\s+".toRegex()
        val NL = "\\r\\n|\\r|\\n".toRegex()
        val COMMENT = """(?x)
          (\#{3,})([^\00]*?)(\1)
        | (\#)([^\n\r]*)
        """.toRegex()
        val SYMBOL_XID = """[\p{L}_][\p{L}_]*""".toRegex()
        val SYMBOL_RAW = """(`)((?:[^`\\]|\\.)*)(\1)""".toRegex()
        val STRING_SINGLE = """(')((?:[^'\\]|\\.)*)(\1)""".toRegex()
        val STRING_DOUBLE = """(")((?:[^"\\]|\\.)*)(\1)""".toRegex()
        val STRING_TUPLE = """("{3,}|'{3,})([^\00]*?)(\1)""".toRegex()
        val KEYWORDS = """(?x)
          namespace[!*]? | extension
        | using[!*]?
        | class | struct | tagged | enum | bitset
        | trait | interface | protocol | convention
        | let | def | fun | type
        | not | is | in | as[?!*]?
        """.toRegex(setOf(RegexOption.COMMENTS, RegexOption.DOT_MATCHES_ALL))
        val PUNCTUATIONS = """(?x)
        [.]{1,3}
        | [{}\[\]()]
        | [,;$@^]
        # start with < >
        | >= | /> | ≥ | ⩾ | >{1,3}
        | <= | </ | ≤ | ⩽ | <{1,3}
        # start with +
        | [+]= | [+]> | [+]{1,2}
        # start with -
        | -= | -> | ⟶ | -{1,2}
        # start with *
        | [*]=?
        # start with / or % or ÷
        | /=?
        | ÷=?
        | %=?
        # start with &
        | &> | &{1,2} | ≻
        | [|]> | [|]{1,2} | ⊁
        | ⊻=? | ⊼=? | ⊽=?
        # start with :
        | :: | :
        # start with ~
        | ~> | ~
        # start with !
        | != | ≠ | !
        # start with ?
        | [?]
        # start with =
        | => | ⇒
        | === | == | =
        # unicode
        | [∈∊∉⊑⋢⨳∀∁∂∃∄¬±√∛∜⊹⋗]
        #
        """.toRegex()
    }

    var stack: MutableList<StackItem> = mutableListOf()

    var contextStack: MutableList<StackContext> = mutableListOf();

    fun interpreter(): Array<StackItem> {
        while (startOffset < endOffset) {
//            matchesWhitespace() ?: continue
            if (matchesWhitespace()) continue
            when (context) {
                StackContext.CODE -> {
                    if (codeComment()) continue
                    if (codeKeywords()) continue
                    if (codeIdentifier()) continue
                    if (codePunctuations()) continue
                }
                StackContext.TEXT -> {

                }
                StackContext.COMMENT -> {

                }
            }
            break
        }
        checkRest()
        return stack.toTypedArray()
    }

    private fun matchesWhitespace(): Boolean {
        val r = tryMatch(WS) ?: return false
        when (context) {
            StackContext.CODE, StackContext.COMMENT -> {
                pushToken(WHITE_SPACE, r)
            }
            StackContext.TEXT -> {
                pushToken(ValkyrieTypes.STRING_LITERAL, r)
            }
        }
        return true
    }

    private fun codeComment(): Boolean {
        val r = tryMatch(COMMENT) ?: return false
        pushToken(ValkyrieTypes.COMMENT, r)
        return true
    }

    private fun codeKeywords(): Boolean {
        assert(context == StackContext.CODE)
        val r = tryMatch(KEYWORDS) ?: return false
        when (r.value) {
            "namespace", "namespace!", "namespace*" -> {
                pushToken(ValkyrieTypes.KW_NAMESPACE, r)
            }
            "using", "using!", "using*" -> {
                pushToken(ValkyrieTypes.KW_IMPORT, r)
            }
            "class", "struct" -> {
                pushToken(ValkyrieTypes.KW_CLASS, r)
            }
            "trait", "interface" -> {
                pushToken(ValkyrieTypes.KW_TRAIT, r)
            }
            "as", "as?", "as!", "as*" -> {
                pushToken(ValkyrieTypes.KW_AS, r)
            }
            "is" -> {
                pushToken(ValkyrieTypes.OP_IS_A, r)
            }
            "def" -> {
                contextStack = "define"
                pushToken(ValkyrieTypes.KW_DEFINE, r)
            }
            else -> {
                pushToken(BAD_CHARACTER, r)
            }
        }
        return true
    }

    private fun codeIdentifier(): Boolean {
        assert(context == StackContext.CODE)
        val r = tryMatch(SYMBOL_XID) ?: tryMatch(SYMBOL_RAW) ?: return false
        when (contextStack) {
            "define" -> {
                pushToken(ValkyrieTypes.KW_MODIFIER, r)
            }
            else -> {
                pushToken(ValkyrieTypes.SYMBOL_XID, r)
            }
        }
        return true
    }

    private fun codePunctuations(): Boolean {
        assert(context == StackContext.CODE)
        val r = tryMatch(PUNCTUATIONS) ?: return false
        when (r.value) {
            // DOT
            "::", "∷" -> pushToken(ValkyrieTypes.PROPORTION, r)
            ":=", "≔" -> pushToken(ValkyrieTypes.OP_BIND, r)
            ":", "∶" -> pushToken(ValkyrieTypes.COLON, r)
            "->", "⟶" -> pushToken(ValkyrieTypes.OP_ARROW, r)
            "=>", "⇒" -> pushToken(ValkyrieTypes.OP_ARROW2, r)
            "." -> {
                when (contextStack) {
                    "define" -> {
                        reShadowWith(ValkyrieTypes.SYMBOL_XID, "args")
                    }
                }
                pushToken(ValkyrieTypes.DOT, r)
            }
            ".." -> pushToken(ValkyrieTypes.DOT, r)
            "..." -> pushToken(ValkyrieTypes.DOT, r)
            ";" -> {
//                when (shadowMode) {
//                    "define" -> {
//                        unShadowWith(ValkyrieTypes.SYMBOL_XID)
//                    }
//                }
                pushToken(ValkyrieTypes.SEMICOLON, r)
            }
            "@" -> pushToken(ValkyrieTypes.AT, r)
            "," -> pushToken(ValkyrieTypes.COMMA, r)
            // start with +
            "++" -> pushToken(ValkyrieTypes.OP_INC, r)
            "+=" -> pushToken(ValkyrieTypes.OP_ADD_ASSIGN, r)
            "+" -> pushToken(ValkyrieTypes.OP_ADD, r)
            // start with -
            "--" -> pushToken(ValkyrieTypes.OP_DEC, r)
            "-=" -> pushToken(ValkyrieTypes.OP_SUB_ASSIGN, r)
            "-" -> pushToken(ValkyrieTypes.OP_SUB, r)
            // start with *
            "*=" -> pushToken(ValkyrieTypes.OP_MUL_ASSIGN, r)
            "*" -> pushToken(ValkyrieTypes.OP_MUL, r)
            // start with /
            "/=" -> pushToken(ValkyrieTypes.OP_DIV_ASSIGN, r)
            "/" -> pushToken(ValkyrieTypes.OP_DIV, r)
            // start with &
            "&&=" -> pushToken(ValkyrieTypes.OP_AND_ASSIGN, r)
            "&&" -> pushToken(ValkyrieTypes.OP_AND, r)
            "&=" -> pushToken(ValkyrieTypes.OP_AND_ASSIGN, r)
            "&" -> pushToken(ValkyrieTypes.OP_AND, r)
            //
            // start with !
            "!!" -> pushToken(ValkyrieTypes.OP_NE, r)
            "!=" -> pushToken(ValkyrieTypes.OP_NE, r)
            "!" -> pushToken(ValkyrieTypes.OP_NOT, r)
            // start with =
            "∈", "∊" -> {
                pushToken(ValkyrieTypes.OP_IN, r)
            }
            "∉" -> {
                pushToken(ValkyrieTypes.OP_NOT_IN, r)
            }
            "≻", "&>" -> {
                pushToken(ValkyrieTypes.OP_AND_THEN, r)
            }
            "⊁", "|>" -> {
                pushToken(ValkyrieTypes.OP_OR_ELSE, r)
            }
            // start with >
            ">>>", "⋙" -> pushToken(ValkyrieTypes.OP_GGG, r)
            ">>", "≫" -> pushToken(ValkyrieTypes.OP_GG, r)
            ">=", "≥", "⩾" -> pushToken(ValkyrieTypes.OP_GEQ, r)
            "/>" -> {
                pushToken(ValkyrieTypes.OP_GS, r)
            }
            ">" -> {
                if (typeContext) {
                    typeContext = false
                }
                pushToken(ValkyrieTypes.OP_GT, r)
            }
            // start with <
            "<<<", "⋘" -> pushToken(ValkyrieTypes.OP_LLL, r)
            "<<", "≪" -> pushToken(ValkyrieTypes.OP_LL, r)
            "<=", "≤", "⩽" -> pushToken(ValkyrieTypes.OP_LEQ, r)
            "</" -> {
                pushToken(ValkyrieTypes.OP_LS, r)
            }
            "<:", "⊑" -> {
                typeContext = true
                pushToken(ValkyrieTypes.OP_IS_A, r)
            }
            "!<:", "⋢" -> {
                typeContext = true
                pushToken(ValkyrieTypes.OP_NOT_A, r)
            }
            "<" -> {
                when (contextStack) {
                    "define" -> {
                        reShadowWith(ValkyrieTypes.SYMBOL_XID, "type")
                    }
                    "type" -> {

                    }
                }
                pushToken(ValkyrieTypes.OP_LT, r)
            }
            // surround with ( )
            "(" -> {
                when (contextStack) {
                    "define" -> {
                        reShadowWith(ValkyrieTypes.SYMBOL_XID, "args")
                    }
                }
                pushToken(ValkyrieTypes.PARENTHESIS_L, r)
            }
            ")" -> {
                pushToken(ValkyrieTypes.PARENTHESIS_R, r)
            }
            "[" -> {
                pushToken(ValkyrieTypes.BRACKET_L, r)
            }
            "]" -> {
                pushToken(ValkyrieTypes.BRACKET_R, r)
            }
            "{" -> {
                pushToken(ValkyrieTypes.BRACE_L, r)
            }
            "}" -> {
                pushToken(ValkyrieTypes.BRACE_R, r)
            }
            "∅", "⤇", "|=>", "⤃", "!=>" -> {
                pushToken(ValkyrieTypes.OP_EMPTY, r)
            }
            else -> pushToken(BAD_CHARACTER, r)
        }
        return true
    }

    private fun matchesK(): Boolean {
        assert(context == StackContext.CODE)
        val patterns = """(?x)
            | 
            | ;
        """.toRegex()
        val r = patterns.matchAt(buffer, startOffset) ?: return false
        when (r.value) {
            "extension" -> pushToken(ValkyrieTypes.KW_EXTENSION, r)
            "namespace*", "namespace" -> pushToken(ValkyrieTypes.KW_NAMESPACE, r)
            "using!" -> pushToken(ValkyrieTypes.KW_IMPORT, r)
            else -> TODO("unreachable ${r.value}")
        }
        return true
    }


    private fun checkRest() {
        if (startOffset < endOffset) {
            pushToken(ValkyrieTypes.COMMENT, startOffset, endOffset)
        }
    }

    private fun tryMatch(pattern: Regex): MatchResult? {
        val r = pattern.matchAt(buffer, startOffset)
        return when {
            r == null -> null
            r.value.isEmpty() -> null
            else -> r
        }
    }

    fun pushToken(token: IElementType, startOffset: Int, endOffset: Int): Boolean {
        stack.add(StackItem(token, startOffset, endOffset, context))
        this.startOffset = endOffset + 1
        return true
    }

    fun pushToken(token: IElementType, match: MatchResult): Boolean {
        stack.add(StackItem(token, match.range.first, match.range.last + 1, context))
        startOffset = match.range.last + 1
        return true
    }

    fun pushToken(token: IElementType, match: MatchGroup): Boolean {
        stack.add(StackItem(token, match.range.first, match.range.last + 1, context))
        startOffset = match.range.last + 1
        return true
    }
}


private fun TokenInterpreter.lastIs(vararg token: IElementType, skipWS: Boolean = true): Boolean {
    for (item in stack.reversed()) {
        if (item.canSkip()) {
            when {
                skipWS -> continue
                else -> return false
            }
        }
        if (item.tokenIs(*token)) return true
    }
    return false
}

private fun TokenInterpreter.lastNot(vararg token: IElementType, skipWS: Boolean = true): Boolean {
    for (item in stack.reversed()) {
        if (item.tokenIs(WHITE_SPACE, ValkyrieTypes.COMMENT)) {
            when {
                skipWS -> continue
                else -> return false
            }
        }
        if (item.tokenIs(*token)) return false
    }
    return true
}


private fun TokenInterpreter.unShadowWith(token: IElementType) {
    for (item in stack.asReversed()) {
        when {
            item.canSkip() -> continue
            else -> {
                item.token = token
                break
            }
        }
    }
    contextStack = ""
}

private fun TokenInterpreter.reShadowWith(token: IElementType, mode: String) {
    for (item in stack.asReversed()) {
        when {
            item.canSkip() -> continue
            else -> {
                item.token = token
                break
            }
        }
    }
    contextStack = mode
}
