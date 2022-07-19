package com.github.valkyrie.language.mixin

import com.github.valkyrie.language.ast.DeclareNode
import com.github.valkyrie.language.psi_node.ValkyrieDefineItemNode
import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import javax.swing.Icon

open class MixinDefineItem(node: ASTNode) : DeclareNode(node) {
    override fun getOriginalElement(): ValkyrieDefineItemNode {
        return this as ValkyrieDefineItemNode
    }
    override fun getNameIdentifier(): PsiElement = originalElement.identifierList.first()
    override fun getIcon(flags: Int): Icon = AllIcons.Nodes.Parameter
    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }
}

