package com.github.valkyrie.language.mixin

import com.github.valkyrie.language.ast.DeclareNode
import com.github.valkyrie.language.psi_node.ValkyrieExtensionStatementNode
import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import javax.swing.Icon

open class MixinExtension(node: ASTNode) : DeclareNode(node) {
    override fun getOriginalElement(): ValkyrieExtensionStatementNode {
        return this as ValkyrieExtensionStatementNode
    }
    override fun getIcon(flags: Int): Icon = AllIcons.Nodes.Module


    override fun getNameIdentifier(): PsiElement {
        return originalElement.firstChild
    }


    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }
}

