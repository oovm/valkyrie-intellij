package com.github.valkyrie.ide.file

import com.intellij.ide.IconProvider
import com.intellij.openapi.util.IconLoader
import com.intellij.psi.PsiElement
import javax.swing.Icon

class ValkyrieIconProvider : IconProvider() {
    override fun getIcon(psiElement: PsiElement, flags: Int): Icon? {
        val file = psiElement.containingFile
        return when {
            file != null && file.name.endsWith(".vk") -> {
                FILE
            }
            else -> {
                null
            }
        }
    }

    companion object {
        val FILE = IconLoader.getIcon("/icons/vk.svg", ValkyrieIconProvider::class.java)
    }
}