package com.github.valkyrie.ide.reference

import com.github.valkyrie.language.psi.ValkyrieClassStatement
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFileSystemItem
import com.intellij.psi.PsiReference
import com.intellij.psi.PsiReferenceProvider
import com.intellij.psi.impl.source.resolve.reference.impl.providers.FileReferenceHelper
import com.intellij.util.ProcessingContext

class ValkyrieFileReference : FileReferenceHelper() {
    override fun getContexts(project: Project, file: VirtualFile): MutableCollection<PsiFileSystemItem> {
        TODO("Not yet implemented $project $file")
    }

    override fun isMine(project: Project, file: VirtualFile): Boolean {
        TODO("Not yet implemented $project $file")
    }
}