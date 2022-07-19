package com.github.valkyrie.ide.reference

import com.intellij.lang.Language
import com.intellij.patterns.ElementPattern
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReference
import com.intellij.psi.PsiReferenceProvider
import com.intellij.psi.PsiReferenceRegistrar
import com.intellij.psi.PsiReferenceService.Hints
import com.intellij.psi.impl.source.resolve.reference.ReferenceProvidersRegistry
import com.intellij.util.ProcessingContext

@Suppress("UnstableApiUsage")
class ReferenceRegistry : ReferenceProvidersRegistry() {
    override fun getRegistrar(language: Language): PsiReferenceRegistrar {
        return ElementRef(language)
    }

    override fun unloadProvidersFor(language: Language) {
        TODO("Not yet implemented")
    }

    override fun doGetReferencesFromProviders(context: PsiElement, hints: Hints): Array<PsiReference> {
        TODO("Not yet implemented")
    }

}

class ElementRef(val language: Language) : PsiReferenceRegistrar() {
    override fun <T : PsiElement?> registerReferenceProvider(pattern: ElementPattern<T>, provider: PsiReferenceProvider, priority: Double) {
        TODO("Not yet implemented")
    }
}

class Pri : PsiReferenceProvider() {
    override fun getReferencesByElement(element: PsiElement, context: ProcessingContext): Array<PsiReference> {
        TODO("Not yet implemented")
    }
}