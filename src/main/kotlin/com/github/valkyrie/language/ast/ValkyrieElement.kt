package com.github.valkyrie.language.ast

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement

open class ValkyrieElement(node: ASTNode) : ASTWrapperPsiElement(node) {
    fun collectDocuments(): List<PsiElement> {
        return listOf()
    }
    fun collectModifiers(): List<PsiElement> {
        return listOf()
    }
}