package com.github.valkyrie.language.mixin

import com.github.valkyrie.ide.view.ValkyrieViewElement
import com.github.valkyrie.language.ast.DeclareNode
import com.github.valkyrie.language.psi_node.ValkyrieExtensionStatementNode
import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import javax.swing.Icon

abstract class MixinExtension(node: ASTNode) : DeclareNode(node) {
    override fun getNameIdentifier(): ValkyrieExtensionStatementNode {
        return this as ValkyrieExtensionStatementNode
    }

    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }

    override val viewIcon: Icon? = AllIcons.Nodes.Module
    override fun addChildrenView(childrenView: MutableSet<ValkyrieViewElement>) {

    }
}

