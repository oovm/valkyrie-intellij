package com.github.valkyrie.ide.file

import com.github.valkyrie.ValkyrieBundle
import com.github.valkyrie.ValkyrieLanguage
import com.github.valkyrie.ide.view.ValkyrieViewElement
import com.intellij.extapi.psi.PsiFileBase
import com.intellij.ide.util.treeView.smartTree.TreeElement
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider
import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.util.PsiTreeUtil

/// ValkyrieFile 是个 PsiElement
class ValkyrieFileNode(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, ValkyrieLanguage) {
    override fun getFileType(): FileType = ValkyrieFileType

    override fun toString(): String = ValkyrieBundle.message("action.create_file")

    fun getChildrenView(): Array<TreeElement> {
        return PsiTreeUtil
            .getChildrenOfTypeAsList(this, NavigatablePsiElement::class.java)
            .filter { it.presentation != null }
            .map { ValkyrieViewElement(it) }
            .toTypedArray()
    }

    fun isIndexFile(): Boolean {
        return this.name == "index.vk"
    }
}