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
class ValkyrieFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, ValkyrieLanguage.INSTANCE) {
    override fun getFileType(): FileType = ValkyrieFileType.INSTANCE

    override fun toString(): String = ValkyrieBundle.message("action.create_file")

    fun getChildrenView(): Array<TreeElement> {
        // TODO: modifier buffer
        val childrenView: MutableSet<ValkyrieViewElement> = mutableSetOf()
        for (item in PsiTreeUtil.getChildrenOfTypeAsList(this, NavigatablePsiElement::class.java)) {
            childrenView.add(ValkyrieViewElement(item))
        }
        return childrenView.toTypedArray()
    }

    fun isIndexFile(): Boolean {
        return this.name == "index.vk"
    }
}