package com.github.valkyrie.ide.reference

import com.intellij.model.Symbol
import com.intellij.model.psi.PsiExternalReferenceHost
import com.intellij.model.psi.PsiSymbolReference
import com.intellij.model.psi.PsiSymbolReferenceHints
import com.intellij.model.psi.PsiSymbolReferenceProvider
import com.intellij.model.search.SearchRequest
import com.intellij.openapi.project.Project

@Suppress("UnstableApiUsage")
class ValkyrieReferenceProvider : PsiSymbolReferenceProvider {
    override fun getReferences(element: PsiExternalReferenceHost, hints: PsiSymbolReferenceHints): MutableCollection<out PsiSymbolReference> {
        return element.ownReferences
    }

    override fun getSearchRequests(project: Project, target: Symbol): MutableCollection<out SearchRequest> {
        TODO("Not yet implemented")
    }
}
