package com.github.valkyrie.ide.folding

import com.github.valkyrie.ide.file.ValkyrieFileNode
import com.github.valkyrie.language.psi.ValkyrieTypes
import com.intellij.lang.ASTNode
import com.intellij.lang.folding.CustomFoldingBuilder
import com.intellij.lang.folding.FoldingDescriptor
import com.intellij.openapi.editor.Document
import com.intellij.openapi.project.DumbAware
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil

class ValkyrieFoldingBuilder : CustomFoldingBuilder(), DumbAware {
    override fun buildLanguageFoldRegions(
        descriptors: MutableList<FoldingDescriptor>,
        root: PsiElement,
        document: Document,
        quick: Boolean
    ) {
        if (root !is ValkyrieFileNode) return
        val visitor = ValkyrieFoldingVisitor(descriptors)
        PsiTreeUtil.processElements(root) {
            it.accept(visitor);
            true
        }
    }

    override fun getLanguagePlaceholderText(node: ASTNode, range: TextRange) =
        when (node.elementType) {
//            BRACKET_BLOCK -> "[...]"
            else -> "..."
        }

    override fun isRegionCollapsedByDefault(node: ASTNode) = false
}