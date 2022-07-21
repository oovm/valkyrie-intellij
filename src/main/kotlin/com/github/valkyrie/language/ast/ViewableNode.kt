package com.github.valkyrie.language.ast


import com.intellij.ide.projectView.PresentationData
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import javax.swing.Icon

abstract class ViewableNode(node: ASTNode) : ValkyrieASTBase(node) {
    abstract override fun getOriginalElement(): PsiElement;
    abstract override fun getIcon(flags: Int): Icon;
    abstract override fun getNavigationElement(): PsiElement;
    override fun getPresentation() = PresentationData(navigationElement.text, "", this.getIcon(0), null)
}

