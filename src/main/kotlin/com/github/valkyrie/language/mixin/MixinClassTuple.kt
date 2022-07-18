package com.github.valkyrie.language.mixin

import com.github.valkyrie.language.ast.ViewableNode
import com.github.valkyrie.language.psi.ValkyrieClassTupleItem
import com.github.valkyrie.language.psi_node.ValkyrieClassTupleItemNode
import com.github.valkyrie.language.psi_node.ValkyrieClassTupleNode
import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import javax.swing.Icon

open class MixinClassTuple(node: ASTNode) : ViewableNode(node) {
    override fun getOriginalElement(): ValkyrieClassTupleItemNode {
        return this as ValkyrieClassTupleItemNode
    }

    override fun getIcon(flags: Int): Icon = AllIcons.Nodes.Field

    override fun getNavigationElement(): PsiElement =  originalElement.typeExpression

    fun getIndexInParent(): Int {
        return this.parent.children.indexOf(this);
    }
}

