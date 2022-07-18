package com.github.valkyrie.language.ast

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement

abstract class ValkyrieElement(node: ASTNode) : ASTWrapperPsiElement(node) {
    abstract override fun getOriginalElement(): PsiElement;
}