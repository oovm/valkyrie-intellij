package com.github.valkyrie.ide.view

import com.github.valkyrie.ide.file.ValkyrieFileNode
import com.github.valkyrie.language.ast.ViewableNode
import com.github.valkyrie.language.psi.ValkyriePresentationItem
import com.intellij.ide.projectView.PresentationData
import com.intellij.ide.structureView.StructureViewTreeElement
import com.intellij.ide.util.treeView.smartTree.SortableTreeElement
import com.intellij.ide.util.treeView.smartTree.TreeElement
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.NavigatablePsiElement

class ValkyrieViewElement(private val self: NavigatablePsiElement, var view: ValkyriePresentationItem? = null) :
    StructureViewTreeElement,
    SortableTreeElement {
    override fun getValue(): Any = self

    override fun navigate(requestFocus: Boolean) = self.navigate(requestFocus)

    override fun canNavigate(): Boolean = self.canNavigate()

    override fun canNavigateToSource(): Boolean = self.canNavigateToSource()

    override fun getAlphaSortKey(): String = self.name ?: ""

    override fun getPresentation(): ItemPresentation {
        return when {
            view != null -> view!!
            self.presentation != null -> self.presentation!!
            else -> PresentationData()
        }
    }

    override fun getChildren(): Array<TreeElement> {
        return when (self) {
            is ValkyrieFileNode -> self.getChildrenView()
            is ViewableNode -> self.getChildrenView()
            else -> arrayOf()
        }
    }

    // TODO: return object
    fun getVisibility(): Boolean = true
}