package com.github.valkyrie.language.mixin

import com.github.valkyrie.language.ast.DeclareNode
import com.github.valkyrie.language.psi_node.ValkyrieTraitStatementNode
import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import javax.swing.Icon


open class MixinTrait(node: ASTNode) : DeclareNode(node) {
    override fun getOriginalElement(): ValkyrieTraitStatementNode {
        return this as ValkyrieTraitStatementNode
    }

    override fun getNameIdentifier(): PsiElement = originalElement
    override fun getIcon(flags: Int): Icon = AllIcons.Nodes.Interface

    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }

    fun getViewName(): String {
        val name = originalElement
        val ty = originalElement.typeExpression;
        return when {
            ty != null -> "${name}: ${ty.text}"
            else -> name.text
        }
    }


}

