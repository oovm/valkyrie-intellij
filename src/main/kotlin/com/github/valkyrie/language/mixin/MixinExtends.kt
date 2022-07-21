package com.github.valkyrie.language.mixin

import com.github.valkyrie.language.ast.DeclareNode
import com.github.valkyrie.language.psi_node.ValkyrieExtendsStatementNode
import com.intellij.icons.AllIcons
import com.intellij.ide.util.treeView.smartTree.TreeElement
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import javax.swing.Icon

open class MixinExtends(node: ASTNode) : DeclareNode(node) {
    override fun getOriginalElement(): ValkyrieExtendsStatementNode {
        return this as ValkyrieExtendsStatementNode
    }

    override fun getNameIdentifier(): PsiElement = originalElement
    override fun getIcon(flags: Int): Icon = AllIcons.Nodes.EntryPoints

    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }


}

