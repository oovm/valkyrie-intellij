@file:OptIn(ExperimentalStdlibApi::class)

package com.github.valkyrie.language.lexer

import com.github.valkyrie.language.psi.ValkyrieTypes
import com.intellij.psi.TokenType.BAD_CHARACTER
import com.intellij.psi.TokenType.WHITE_SPACE

import com.intellij.psi.tree.IElementType

class TokenInterpreter(val buffer: CharSequence, var startOffset: Int, val endOffset: Int, var context: StackContext) {
    companion object {
        val EOL = "\\R".toRegex()
        val ROL = "[^\\r\\n]+".toRegex()
        val WS = "\\s+".toRegex()
        val NL = "\\r\\n|\\r|\\n".toRegex()
        val COMMENT_LINE = "//[^\\n\\r]*".toRegex()
        val SYMBOL_XID = "[a-zA-Z_][a-zA-Z0-9_]*".toRegex()
        val SYMBOL_RAW = "(`)((?:[^`\\\\]|\\\\.)*)(`)".toRegex()
        val DOTS = "\\.{1,3}".toRegex()
        val KEYWORDS = """(?x)
            let
          | def
          | namespace[!*]?
          | using[!*]?
          | is
          | as[?!*]?
          | class
          | trait
        """.toRegex(setOf(RegexOption.COMMENTS, RegexOption.DOT_MATCHES_ALL))
        val PUNCTUATIONS = """(?x)
            [.]{1,3}
            | [{}\[\]()]
            | [,@;]
            # start with < >
            | >>> | >> | >= | /> | >
            | <<< | << | <= | </ | < | ≤ 
            # start with +
            | \+\+ | \+=?
            # start with -
            | -- | -=?
            # start with *
            | \*=?
            # start with / or % or ÷
            | /=?
            | ÷=?
            | %=?
            # start with &
            | &&=? | &=?
            | \|\|=? | \|=?
            | ⊻ | ⊼ | ⊽
            # start with :
            | ::
            | !
            | != | ≠
            | \?
            | === | == | =
            # in
            | ∈
            #
        """.toRegex()
    }

    var stack: MutableList<StackItem> = mutableListOf()

    var typeContext = false

    var shadowKeyword: String? = null;

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
        val r = tryMatch(COMMENT_LINE) ?: return false
        pushToken(ValkyrieTypes.COMMENT_LINE, r)
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
            "class" -> {
                pushToken(ValkyrieTypes.KW_CLASS, r)
            }
            "as", "as?", "as!", "as*" -> {
                pushToken(ValkyrieTypes.KW_AS, r)
            }
            "is" -> {
                pushToken(ValkyrieTypes.OP_IS_A, r)
            }
            else -> {
                pushToken(BAD_CHARACTER, r)
            }
        }
        return true
    }

    private fun codeIdentifier(): Boolean {
        assert(context == StackContext.CODE)
        var r = tryMatch(SYMBOL_XID)
        if (r == null) {
            r = tryMatch(SYMBOL_RAW) ?: return false
            pushToken(ValkyrieTypes.SYMBOL_RAW, r)
        }
        else {
            pushToken(ValkyrieTypes.SYMBOL_XID, r)
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
            "." -> pushToken(ValkyrieTypes.DOT, r)
            ".." -> pushToken(ValkyrieTypes.DOT, r)
            "..." -> pushToken(ValkyrieTypes.DOT, r)
            ";" -> pushToken(ValkyrieTypes.SEMICOLON, r)
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
            "∈" -> {
                pushToken(ValkyrieTypes.OP_IN, r)
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
            "!<:", "⋢", "!⊑" -> {
                typeContext = true
                pushToken(ValkyrieTypes.OP_NOT_A, r)
            }
            "<" -> {
                if (typeContext) {
                    typeContext = false
                }
                pushToken(ValkyrieTypes.OP_LT, r)
            }
            // surround with ( )
            "(" -> {

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
            pushToken(ValkyrieTypes.COMMENT_BLOCK, startOffset, endOffset)
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

    fun pushToken(token: IElementType, startOffset: Int, endOffset: Int) {
        stack.add(StackItem(token, startOffset, endOffset, context))
        this.startOffset = endOffset + 1
    }

    fun pushToken(token: IElementType, match: MatchResult) {
        stack.add(StackItem(token, match.range.first, match.range.last + 1, context))
        startOffset = match.range.last + 1
    }

    fun pushToken(token: IElementType, match: MatchGroup) {
        stack.add(StackItem(token, match.range.first, match.range.last + 1, context))
        startOffset = match.range.last + 1
    }
}

fun TokenInterpreter.lastIs(vararg token: IElementType, skipWS: Boolean = true): Boolean {
    for (item in stack.reversed()) {
        if (item.tokenIs(WHITE_SPACE, ValkyrieTypes.COMMENT_LINE, ValkyrieTypes.COMMENT_BLOCK)) {
            when {
                skipWS -> continue
                else -> return false
            }
        }
        if (item.tokenIs(*token)) return true
    }
    return false
}

fun TokenInterpreter.lastNot(vararg token: IElementType, skipWS: Boolean = true): Boolean {
    for (item in stack.reversed()) {
        if (item.tokenIs(WHITE_SPACE, ValkyrieTypes.COMMENT_LINE, ValkyrieTypes.COMMENT_BLOCK)) {
            when {
                skipWS -> continue
                else -> return false
            }
        }
        if (item.tokenIs(*token)) return false
    }
    return true
}


