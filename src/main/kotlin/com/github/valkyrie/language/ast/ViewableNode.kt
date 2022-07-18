package com.github.valkyrie.language.ast


import com.github.valkyrie.ide.view.ValkyrieViewElement
import com.github.valkyrie.language.psi.ValkyriePresentationItem
import com.intellij.ide.util.treeView.smartTree.TreeElement
import com.intellij.lang.ASTNode
import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.PsiElement
import javax.swing.Icon

abstract class ViewableNode(node: ASTNode) : ValkyrieElement(node),
    NavigatablePsiElement {
    abstract override fun getIcon(flags: Int): Icon;
    abstract override fun getNavigationElement(): PsiElement;
    override fun getPresentation() = ValkyriePresentationItem(navigationElement.text, this.getIcon(0))
    open fun getChildrenView(): Array<TreeElement> {
       return  arrayOf()
    }
}

