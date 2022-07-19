package com.github.valkyrie.language.ast

import com.github.valkyrie.ide.highlight.ValkyrieHighlightColor

class FunctionKind(
    val isMethod: Boolean = false,
    val isStatic: Boolean = false,
    val isConstructor: Boolean = false,
    val isMutable: Boolean = false
) {
    val color: ValkyrieHighlightColor
        get() = when {
            isMethod -> {
                ValkyrieHighlightColor.SYM_FUNCTION_SELF
            }
            else -> {
                ValkyrieHighlightColor.SYM_FUNCTION_FREE
            }
        }


    companion object {
        val FREE_FUNCTION = FunctionKind()
        val METHOD = FunctionKind(isMethod = true)
        val STATIC_METHOD = FunctionKind(isMethod = true, isStatic = true)
    }
}