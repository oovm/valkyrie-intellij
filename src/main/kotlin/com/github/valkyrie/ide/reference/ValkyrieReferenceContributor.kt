package com.github.valkyrie.ide.reference

import com.github.valkyrie.language.psi.ValkyrieIdentifier
import com.intellij.patterns.PlatformPatterns
import com.intellij.psi.PsiReferenceContributor
import com.intellij.psi.PsiReferenceRegistrar

class ValkyrieReferenceContributor : PsiReferenceContributor() {
    override fun registerReferenceProviders(registrar: PsiReferenceRegistrar) {
        registrar.registerReferenceProvider(
            PlatformPatterns.psiElement(ValkyrieIdentifier::class.java),
            ClassReferenceProvider()
        )
    }
}

