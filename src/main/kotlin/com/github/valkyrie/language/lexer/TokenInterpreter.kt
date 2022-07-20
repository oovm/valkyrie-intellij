@file:OptIn(ExperimentalStdlibApi::class)

package com.github.valkyrie.language.lexer

import com.github.valkyrie.language.lexer.LexerContext.*
import com.github.valkyrie.language.psi.ValkyrieTypes
import com.intellij.psi.TokenType.BAD_CHARACTER
import com.intellij.psi.TokenType.WHITE_SPACE

import com.intellij.psi.tree.IElementType

private val KEYWORDS = """(?x)
      namespace[*!]? | extension
    | using[*!]?
    | class | struct | tagged | enum | bitset
    | trait | interface | protocol | convention
    | let | def | fun | type
    | not | is | in | as[*!?]?
    """.toRegex(setOf(RegexOption.COMMENTS, RegexOption.DOT_MATCHES_ALL))
private val PUNCTUATIONS = """(?x)
      [.]{1,3}
    | [{}\[\]()]
    | [,;$^]
    | @[*!?@]?
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
private val COMMENTS = """(?x)
      (\#{3,})([^\00]*?)(\1)
    | (\#)([^\n\r]*)
    """.toRegex()
private val STRINGS = """(?x)
      ("{3,}|'{3,})([^\00]*?)(\1)
    | '[^']*'
    | "[^"]*"
    | «[^»]*»
    | ‘[^’]*’
    | “[^”]*”
    """.toRegex()

@Suppress("MemberVisibilityCanBePrivate")
class TokenInterpreter(val buffer: CharSequence, var startOffset: Int, val endOffset: Int) {
    var stack: MutableList<StackItem> = mutableListOf()

    var contextStack: MutableList<LexerContext> = mutableListOf();

    val context: LexerContext
        get() = contextStack.lastOrNull() ?: LexerContext.TopCoding

    fun interpreter(): Array<StackItem> {
        while (startOffset < endOffset) {
//            matchesWhitespace() ?: continue
            if (matchesWhitespace()) continue
            if (codeComment()) continue
            if (codeString()) continue
            if (codePunctuations()) continue
            if (codeKeywords()) continue
            if (codeIdentifier()) continue
            break
        }
        checkRest()
        return stack.toTypedArray()
    }

    private fun matchesWhitespace(): Boolean {
        val r = tryMatch("\\s+".toRegex()) ?: return false
        pushToken(WHITE_SPACE, r)
        return true
    }

    private fun codeComment(): Boolean {
        val r = tryMatch(COMMENTS) ?: return false
        pushToken(ValkyrieTypes.COMMENT, r)
        return true
    }

    private fun codeString(): Boolean {
        val r = tryMatch(STRINGS) ?: return false
        pushToken(ValkyrieTypes.STRING_RAW, r)
        return true
    }

    private fun codeKeywords(): Boolean {

        val r = tryMatch(KEYWORDS) ?: return false
        when (context) {
            Coding -> {
                pushToken(ValkyrieTypes.SYMBOL_XID, r);
                return true
            }
            else -> {}
        }
        when (r.value) {
            "namespace", "namespace!", "namespace*" -> {
                pushToken(ValkyrieTypes.KW_NAMESPACE, r)
            }
            "using", "using!", "using*" -> {
                pushToken(ValkyrieTypes.KW_IMPORT, r)
            }
            "class", "struct" -> {
                enterContext(CatchModifier)
                pushToken(ValkyrieTypes.KW_CLASS, r)
            }
            "trait", "interface" -> {
                pushToken(ValkyrieTypes.KW_TRAIT, r)
            }
            "as", "as?", "as!", "as*" -> {
                enterContext(Type)
                pushToken(ValkyrieTypes.KW_AS, r)
            }
            "is" -> {
                enterContext(Type)
                pushToken(ValkyrieTypes.OP_IS_A, r)
            }
            "not" -> {
                pushToken(ValkyrieTypes.OP_NOT_A, r)
            }
            "def" -> {
                enterContext(CatchModifier)
                pushToken(ValkyrieTypes.KW_DEFINE, r)
            }
            else -> {
                pushToken(BAD_CHARACTER, r)
            }
        }
        return true
    }

    private fun codeIdentifier(): Boolean {
        val xid = """(?x)
        [\p{L}_][\p{L}_\00]*
        | (`)((?:[^`\\]|\\.)*)(\1)
        """.toRegex()
        val r = tryMatch(xid) ?: return false
        when (context) {
            CatchModifier -> {
                pushToken(ValkyrieTypes.KW_MODIFIER, r)
            }
            else -> {
                pushToken(ValkyrieTypes.SYMBOL_XID, r)
            }
        }
        return true
    }

    private fun codePunctuations(): Boolean {

        val r = tryMatch(PUNCTUATIONS) ?: return false
        when (r.value) {
            // DOT
            ":=", "≔" -> pushToken(ValkyrieTypes.OP_BIND, r)
            "->", "⟶" -> pushToken(ValkyrieTypes.OP_ARROW, r)
            "=>", "⇒" -> pushToken(ValkyrieTypes.OP_ARROW2, r)
            "." -> {
                when (context) {
                    CatchModifier -> resetToken(ValkyrieTypes.SYMBOL_XID)
                    else -> {}
                }
                pushToken(ValkyrieTypes.DOT, r)
            }
            ":", "∶" -> {
                when (context) {
                    CatchModifier -> resetToken(ValkyrieTypes.SYMBOL_XID)
                    else -> {}
                }
                pushToken(ValkyrieTypes.COLON, r)
            }

            "::", "∷" -> {
                when (context) {
                    CatchModifier -> resetToken(ValkyrieTypes.SYMBOL_XID)
                    else -> {}
                }
                pushToken(ValkyrieTypes.PROPORTION, r)

            }
            ".." -> pushToken(ValkyrieTypes.DOT, r)
            "..." -> pushToken(ValkyrieTypes.DOT, r)
            ";" -> {
                when (context) {
                    CatchModifier -> resetToken(ValkyrieTypes.SYMBOL_XID)
                    else -> {}
                }
                endContext()
                pushToken(ValkyrieTypes.SEMICOLON, r)
            }
            "@", "@@", "@!", "@?" -> pushToken(ValkyrieTypes.AT, r)
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
            ">" -> when (context) {
                Type -> {
                    pushToken(ValkyrieTypes.GENERIC_R, r)
                    endContext()
                }
                else -> {
                    pushToken(ValkyrieTypes.OP_GT, r)
                }
            }
            // start with <
            "<<<", "⋘" -> pushToken(ValkyrieTypes.OP_LLL, r)
            "<<", "≪" -> pushToken(ValkyrieTypes.OP_LL, r)
            "<=", "≤", "⩽" -> pushToken(ValkyrieTypes.OP_LEQ, r)
            "</" -> {
                pushToken(ValkyrieTypes.OP_LS, r)
            }
            "<:", "⊑" -> {
                enterContext(Type)
                pushToken(ValkyrieTypes.OP_IS_A, r)
            }
            "!<:", "⋢" -> {
                enterContext(Type)
                pushToken(ValkyrieTypes.OP_NOT_A, r)
            }
            "<" -> when (context) {
                CatchModifier, Coding -> {
                    resetToken(ValkyrieTypes.SYMBOL_XID)
                    pushToken(ValkyrieTypes.GENERIC_L, r)
                    resetContext(Type)
                }
                Type -> {
                    pushToken(ValkyrieTypes.GENERIC_L, r)
                    enterContext(Type)
                }
                else -> {
                    pushToken(ValkyrieTypes.OP_LT, r)
                }
            }
            // surround with ( )
            "(" -> {
                when (context) {
                    CatchModifier -> {
                        resetToken(ValkyrieTypes.SYMBOL_XID)
                        resetContext(Coding)
                    }
                    else -> {

                    }
                }
                pushToken(ValkyrieTypes.PARENTHESIS_L, r)
            }
            ")" -> {
                pushToken(ValkyrieTypes.PARENTHESIS_R, r)
                endContext()
            }
            "[" -> {
                pushToken(ValkyrieTypes.BRACKET_L, r)
            }
            "]" -> {
                pushToken(ValkyrieTypes.BRACKET_R, r)
            }
            "{" -> {
                when (context) {
                    CatchModifier -> {
                        resetToken(ValkyrieTypes.SYMBOL_XID)
                        resetContext(TopCoding)
                    }
                    else -> {

                    }
                }
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

private fun TokenInterpreter.resetToken(token: IElementType) {
    for (item in stack.asReversed()) {
        when {
            item.canSkip() -> continue
            else -> {
                item.token = token
                break
            }
        }
    }
}

private fun TokenInterpreter.resetContext(context: LexerContext) {
    contextStack.removeLastOrNull()
    contextStack.add(context)
}

private fun TokenInterpreter.enterContext(context: LexerContext) {
    contextStack.add(context)
}

private fun TokenInterpreter.endContext() {
    contextStack.removeLastOrNull()
}

private fun TokenInterpreter.contextIs(vararg check: LexerContext): Boolean {
    for (c in check) {
        if (context == c) {
            return true
        }
    }
    return false
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
