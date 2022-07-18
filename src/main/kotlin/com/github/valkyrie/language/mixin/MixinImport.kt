package com.github.valkyrie.language.mixin

import com.github.valkyrie.language.ast.ViewableNode
import com.github.valkyrie.language.psi_node.ValkyrieImportStatementNode
import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import javax.swing.Icon

open class MixinImport(node: ASTNode) : ViewableNode(node) {
    override fun getIcon(flags: Int): Icon = AllIcons.Nodes.Class
    override fun getOriginalElement(): ValkyrieImportStatementNode {
        return this as ValkyrieImportStatementNode
    }

    override fun getNavigationElement(): PsiElement {
        return this
    }
}

