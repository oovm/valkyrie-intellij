package com.github.valkyrie.language.ast

import com.github.valkyrie.ide.formatter.FormatSpace
import com.github.valkyrie.language.psi.ValkyrieNormalPattern
import com.github.valkyrie.language.psi.ValkyrieIdentifier
import com.intellij.formatting.Block
import com.intellij.formatting.Spacing
import com.intellij.lang.ASTNode
import com.intellij.psi.TokenType


fun ASTNode?.isWhitespaceOrEmpty(): Boolean {
    return this == null || textLength == 0 || elementType == TokenType.WHITE_SPACE
}

fun Block.computeSpacing(child1: Block?, child2: Block, ctx: FormatSpace): Spacing? {
    return ctx.spacingBuilder.getSpacing(this, child1, child2)
}

fun hasModifier(node: List<ValkyrieIdentifier>, modifier: String, skip_last: Boolean = true): Boolean {
    val size = node.size - if (skip_last) {
        1
    } else {
        0
    }
    for (i in 0 until size) {
        if (node[i].text == modifier) {
            return true
        }
    }
    return false
}

fun ValkyrieNormalPattern.isMutable(): Boolean {
    return hasModifier(this.identifierList, "mut", false)
}

//fun ValkyriePatternRest?.hasModifier(modifier: String, skip_last: Boolean = true): Boolean {
//    return getModifier(this as PsiElement, modifier, skip_last)
//}
//
//
//fun ValkyriePatternItem.isMutable(force_mut: Boolean, skip_last: Boolean = true): Boolean {
//    this.modifierSymbols?.let {
//        return it.isMutable(force_mut, skip_last)
//    }
//    this.patternRest?.let {
//        return it.isMutable(force_mut, skip_last)
//    }
//    return false
//}
//
//fun ValkyrieModifiers?.isMutable(force_mut: Boolean, skip_last: Boolean = true): Boolean = when (force_mut) {
//    true -> true
//    false -> this?.hasModifier("mut", skip_last) ?: false
//}
//
//fun ValkyriePatternRest?.isMutable(force_mut: Boolean, skip_last: Boolean = true): Boolean = when (force_mut) {
//    true -> true
//    false -> this?.hasModifier("mut", skip_last) ?: false
//}
//
