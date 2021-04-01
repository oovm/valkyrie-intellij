package com.github.valkyrie.language.mixin

import com.github.valkyrie.language.ast.ViewableNode
import com.github.valkyrie.language.psi.ValkyrieClassTupleItem
import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import javax.swing.Icon

abstract class MixinClassTuple(node: ASTNode) : ViewableNode(node),
    ValkyrieClassTupleItem {
    /// return index in parent
    override fun getViewName(): String {
        return this.parent.children.indexOf(this).toString()
    }
    override val viewIcon: Icon = AllIcons.Nodes.Field
    override fun getNavigationElement(): PsiElement =  this.typeExpression
}

