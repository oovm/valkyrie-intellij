@file:OptIn(ExperimentalStdlibApi::class)

package com.github.valkyrie.language.lexer

import com.github.valkyrie.language.psi.ValkyrieTypes

class TokenInterpreter(val buffer: CharSequence, var startOffset: Int, val endOffset: Int, var context: StackContext) {
    companion object {
        val EOL = "\\R".toRegex()
        val ROL = "[^\\r\\n]+".toRegex()
        val WS_ROL = "([^\\S\\r\\n]*)([^\\r\\n]*)".toRegex()
        val WS = "[^\\S\\r\\n]+".toRegex()
        val NL = "\\r\\n|\\r|\\n".toRegex()
        val NAMESPACE = "namespace[!]?".toRegex()
        val ASTERISK = "[*]+".toRegex()
    }

    var stack: MutableList<StackItem> = mutableListOf()

    var typeContext = false

    var shadowKeyword = false;

    fun interpreter(): Array<StackItem> {
        while (startOffset < endOffset) {
            if (matchesWhitespace()) continue
            if (matchesNewline()) continue
            when (context) {
                StackContext.CODE -> {
                    if (matchesSettable()) continue
                }
                StackContext.STRING -> {

                }
                StackContext.TEXT -> {}
            }
            break
        }
        checkRest()
        return stack.toTypedArray()
    }

    private fun matchesWhitespace(): Boolean {
        val r = WS.matchAt(buffer, startOffset) ?: return false
        return false
        return addOffset(r)
    }

    private fun matchesNewline(): Boolean {
        return false
    }

    private fun matchesTopLevelKeywords(): Boolean {
        assert(context == StackContext.CODE)
        val patterns = """(?x)
            | extension
            | namespace[!*]?
            | using[!*]?
        """.toRegex()
        val r = patterns.matchAt(buffer, startOffset) ?: return false
        if (shadowKeyword) {
            shadowKeyword = false
            return addOffset(r)
        }
        when (r.value) {
            "extension" -> stack.add(StackItem(ValkyrieTypes.KW_EXTENSION, r, context))
            "namespace!", "namespace*", "namespace" -> stack.add(StackItem(ValkyrieTypes.KW_NAMESPACE, r, context))
            "using!" -> stack.add(StackItem(ValkyrieTypes.KW_IMPORT, r, context))
            else -> TODO("unreachable ${r.value}")
        }
        return addOffset(r)
    }

    private fun matchesSettable(): Boolean {
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
        """.toRegex()
        val r = patterns.matchAt(buffer, startOffset) ?: return false
        when (r.value) {
            // start with +
            "++" -> stack.add(StackItem(ValkyrieTypes.OP_INC, r, context))
            "+=" -> stack.add(StackItem(ValkyrieTypes.OP_ADD_ASSIGN, r, context))
            "+" -> stack.add(StackItem(ValkyrieTypes.OP_ADD, r, context))
            // start with -
            "--" -> stack.add(StackItem(ValkyrieTypes.OP_DEC, r, context))
            "-=" -> stack.add(StackItem(ValkyrieTypes.OP_SUB_ASSIGN, r, context))
            "-" -> stack.add(StackItem(ValkyrieTypes.OP_SUB, r, context))
            // start with *
            "*=" -> stack.add(StackItem(ValkyrieTypes.OP_MUL_ASSIGN, r, context))
            "*" -> stack.add(StackItem(ValkyrieTypes.OP_MUL, r, context))
            // start with /
            "/=" -> stack.add(StackItem(ValkyrieTypes.OP_DIV_ASSIGN, r, context))
            "/" -> stack.add(StackItem(ValkyrieTypes.OP_DIV, r, context))
            // start with &
            "&&=" -> stack.add(StackItem(ValkyrieTypes.OP_AND_ASSIGN, r, context))
            "&&" -> stack.add(StackItem(ValkyrieTypes.OP_AND, r, context))
            "&=" -> stack.add(StackItem(ValkyrieTypes.OP_AND_ASSIGN, r, context))
            "&" -> stack.add(StackItem(ValkyrieTypes.OP_AND, r, context))
            //
            "::", "∷" -> stack.add(StackItem(ValkyrieTypes.OP_PROPORTION, r, context))
            ":=", "≔" -> stack.add(StackItem(ValkyrieTypes.OP_BIND, r, context))
            ":", "∶" -> stack.add(StackItem(ValkyrieTypes.OP_COLON, r, context))
            // start with !
            "!!" -> stack.add(StackItem(ValkyrieTypes.OP_NE, r, context))
            "!=" -> stack.add(StackItem(ValkyrieTypes.OP_NE, r, context))
            "!" -> stack.add(StackItem(ValkyrieTypes.OP_NOT, r, context))
            // start with =
            "∈" -> {
                stack.add(StackItem(ValkyrieTypes.OP_IN, r, context))
            }
            // start with >
            ">>>", "⋙" -> stack.add(StackItem(ValkyrieTypes.OP_GGG, r, context))
            ">>", "≫" -> stack.add(StackItem(ValkyrieTypes.OP_GG, r, context))
            ">=", "≥", "⩾" -> stack.add(StackItem(ValkyrieTypes.OP_GEQ, r, context))
            "/>" -> {
                stack.add(StackItem(ValkyrieTypes.OP_GS, r, context))
            }
            ">" -> {
                if (typeContext) {
                    typeContext = false
                }
                stack.add(StackItem(ValkyrieTypes.OP_GT, r, context))
            }
            // start with <
            "<<<", "⋘" -> stack.add(StackItem(ValkyrieTypes.OP_LLL, r, context))
            "<<", "≪" -> stack.add(StackItem(ValkyrieTypes.OP_LL, r, context))
            "<=", "≤", "⩽" -> stack.add(StackItem(ValkyrieTypes.OP_LEQ, r, context))
            "</" -> {
                stack.add(StackItem(ValkyrieTypes.OP_LS, r, context))
            }
            "<:", "⊑" -> {
                typeContext = true
                stack.add(StackItem(ValkyrieTypes.OP_IS_A, r, context))
            }
            "!<:", "⋢", "!⊑" -> {
                typeContext = true
                stack.add(StackItem(ValkyrieTypes.OP_NOT_A, r, context))
            }
            // surround with ( )
            "(" -> {
                if (shadowKeyword) {
                    shadowKeyword = false
                }
                stack.add(StackItem(ValkyrieTypes.L_PAREN, r, context))
            }
            ")" -> {
                stack.add(StackItem(ValkyrieTypes.R_PAREN, r, context))
            }
            "[" -> {
                if (shadowKeyword) {
                    shadowKeyword = false
                }
                stack.add(StackItem(ValkyrieTypes.L_BRACK, r, context))
            }
            "]" -> {
                stack.add(StackItem(ValkyrieTypes.R_BRACK, r, context))
            }

            else -> TODO("unreachable ${r.value}")
        }
        return addOffset(r)
    }

    private fun matchesPunctuations(): Boolean {
        assert(context == StackContext.CODE)
        val patterns = """(?x)
            | 
            | ;
        """.toRegex()
        val r = patterns.matchAt(buffer, startOffset) ?: return false
        when (r.value) {
            "extension" -> stack.add(StackItem(ValkyrieTypes.KW_EXTENSION, r, context))
            "namespace*", "namespace" -> stack.add(StackItem(ValkyrieTypes.KW_NAMESPACE, r, context))
            "using!" -> stack.add(StackItem(ValkyrieTypes.KW_IMPORT, r, context))
            else -> TODO("unreachable ${r.value}")
        }
        return addOffset(r)
    }


    private fun checkRest() {
        if (startOffset < endOffset) {
            stack.add(StackItem(ValkyrieTypes.COMMENT_BLOCK, startOffset, endOffset, context))
        }
    }

    fun addOffset(r: MatchResult): Boolean {
        startOffset = r.range.last + 1
        return true
    }
}