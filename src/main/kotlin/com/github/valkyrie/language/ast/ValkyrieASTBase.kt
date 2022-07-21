package com.github.valkyrie.language.ast

import com.github.valkyrie.ide.view.ValkyrieViewElement
import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.ide.util.treeView.smartTree.TreeElement
import com.intellij.lang.ASTNode
import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil

open class ValkyrieASTBase(node: ASTNode) : ASTWrapperPsiElement(node) {
    fun collectDocuments(): List<PsiElement> {
        return listOf()
    }
    fun collectAnnotations(): List<PsiElement> {
        return listOf()
    }
    open fun getChildrenView(): Array<TreeElement> {
        val childrenView: MutableSet<ValkyrieViewElement> = mutableSetOf()
        for (item in PsiTreeUtil.getChildrenOfTypeAsList(this, NavigatablePsiElement::class.java)) {
            childrenView.add(ValkyrieViewElement(item))
        }
        return childrenView.toTypedArray()
//        return  arrayOf()
    }
}