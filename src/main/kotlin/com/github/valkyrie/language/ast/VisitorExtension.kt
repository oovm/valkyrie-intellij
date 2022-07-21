package com.github.valkyrie.language.ast

import com.github.valkyrie.ide.view.ValkyrieViewElement
import com.github.valkyrie.language.psi.ValkyrieDefineTuple
import com.github.valkyrie.language.psi.ValkyrieImportStatement
import com.github.valkyrie.language.psi.ValkyrieModifiers
import com.intellij.ide.projectView.PresentationData
import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.util.PsiTreeUtil


fun ValkyrieImportStatement?.addChildrenView(list: MutableList<ValkyrieViewElement>) {
    if (this == null) return
    // list.add( this )
}

fun ValkyrieDefineTuple?.addChildrenView(list: MutableList<ValkyrieViewElement>) {
    if (this == null) return
    PsiTreeUtil
        .getChildrenOfTypeAsList(this, NavigatablePsiElement::class.java)
        .forEach {
            // PresentationData(it.text, "std::modifiers", this.getIcon(0), null)
            // val view = PresentationData(it.text, "", this.getIcon(0), null)
            list.add(ValkyrieViewElement(it))
        }
}

fun ValkyrieModifiers?.addChildrenView(list: MutableList<ValkyrieViewElement>) {
    if (this == null) return
    PsiTreeUtil
        .getChildrenOfTypeAsList(this, NavigatablePsiElement::class.java)
        .forEach {
            // PresentationData(it.text, "std::modifiers", this.getIcon(0), null)
            val view = PresentationData(it.text, "", this.getIcon(0), null)
            list.add(ValkyrieViewElement(it, view))
        }
}