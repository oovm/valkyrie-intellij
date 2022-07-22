package com.github.valkyrie.language.mixin

import com.intellij.model.Symbol
import com.intellij.model.psi.PsiSymbolReference
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement

class SymbolTarget(val target: PsiElement): PsiSymbolReference {
    override fun getElement(): PsiElement = target

    override fun getRangeInElement(): TextRange {
        TODO("Not yet implemented")
    }

    override fun resolveReference(): MutableCollection<out Symbol> {
        TODO("Not yet implemented")
    }


}