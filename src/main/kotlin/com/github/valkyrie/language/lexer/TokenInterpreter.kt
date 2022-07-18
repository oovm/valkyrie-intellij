@file:OptIn(ExperimentalStdlibApi::class)

package com.github.valkyrie.language.lexer

import com.github.valkyrie.language.psi.ValkyrieTypes
import com.intellij.psi.TokenType.WHITE_SPACE
import com.intellij.psi.tree.IElementType

class TokenInterpreter(val buffer: CharSequence, var startOffset: Int, val endOffset: Int, var context: StackContext) {
    companion object {
        val EOL = "\\R".toRegex()
        val ROL = "[^\\r\\n]+".toRegex()
        val WS = "\\s+".toRegex()
        val NL = "\\r\\n|\\r|\\n".toRegex()
        val ASTERISK = "[*]+".toRegex()
    }

    var stack: MutableList<StackItem> = mutableListOf()

    var typeContext = false

    var shadowKeyword = false;

    fun interpreter(): Array<StackItem> {
        while (startOffset < endOffset) {
            if (matchesWhitespace()) continue
            when (context) {
                StackContext.CODE -> {
                    if (codeNamespace()) continue
                    if (codePunctuations()) continue
                }
                StackContext.TEXT -> {

                }
                StackContext.TEXT -> {}
                StackContext.COMMENT -> {

                }
            }
            break
        }
        checkRest()
        return stack.toTypedArray()
    }

    private fun matchesWhitespace(): Boolean {
        val token = "\\s+".toRegex();
        val r = token.matchAt(buffer, startOffset) ?: return false
        when (context) {
            StackContext.CODE, StackContext.COMMENT -> {
                pushToken(WHITE_SPACE, r)
            }
            StackContext.TEXT -> {
                pushToken(ValkyrieTypes.STRING_LITERAL, r)
            }
        }
        return addOffset(r)
    }

    private fun codeNamespace(): Boolean {
        assert(context == StackContext.CODE)
        val namespace = "namespace[!*]?".toRegex()
        val r = namespace.matchAt(buffer, startOffset) ?: return false
        if (shadowKeyword) {
            shadowKeyword = false
            pushToken(ValkyrieTypes.KW_NAMESPACE, r)
        }
        else {
            pushToken(ValkyrieTypes.KW_NAMESPACE, r)
        }
        return addOffset(r)
    }

    private fun codePunctuations(): Boolean {
        assert(context == StackContext.CODE)
        val patterns = """(?x)
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
            | ;
            | , 
        """.toRegex(setOf(RegexOption.COMMENTS, RegexOption.DOT_MATCHES_ALL))
        val r = patterns.matchAt(buffer, startOffset) ?: return false
        when (r.value) {
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
            "::", "∷" -> pushToken(ValkyrieTypes.OP_PROPORTION, r)
            ":=", "≔" -> pushToken(ValkyrieTypes.OP_BIND, r)
            ":", "∶" -> pushToken(ValkyrieTypes.OP_COLON, r)
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
            // surround with ( )
            "(" -> {
                shadowKeyword = false
                pushToken(ValkyrieTypes.PARENTHESIS_L, r)
            }
            ")" -> {
                pushToken(ValkyrieTypes.PARENTHESIS_R, r)
            }
            "[" -> {
                shadowKeyword = false
                pushToken(ValkyrieTypes.BRACKET_L, r)
            }
            "]" -> {
                pushToken(ValkyrieTypes.BRACKET_R, r)
            }
            "{" -> {
                shadowKeyword = false
                pushToken(ValkyrieTypes.BRACE_L, r)
            }
            "}" -> {
                pushToken(ValkyrieTypes.BRACE_R, r)
            }
            ";" -> {
                pushToken(ValkyrieTypes.SEMICOLON, r)
            }
            "," -> {
                pushToken(ValkyrieTypes.COMMA, r)
            }
            else -> TODO("unreachable ${r}")
        }
        return addOffset(r)
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
        return addOffset(r)
    }


    private fun checkRest() {
        if (startOffset < endOffset) {
            pushToken(ValkyrieTypes.COMMENT_BLOCK, startOffset, endOffset)
        }
    }

    fun pushToken(token: IElementType, startOffset: Int, endOffset: Int) {
        pushToken(token, startOffset, endOffset)
        this.startOffset = endOffset + 1
    }
    fun pushToken(token: IElementType, match: MatchResult) {
        pushToken(token, match);
        startOffset = match.range.last + 1
    }
}