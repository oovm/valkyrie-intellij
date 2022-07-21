package com.github.valkyrie.language.mixin

import com.github.valkyrie.ide.file.ValkyrieIconProvider
import com.github.valkyrie.ide.view.ValkyrieViewElement
import com.github.valkyrie.language.ast.ViewableNode
import com.github.valkyrie.language.psi.ValkyrieModifiers
import com.github.valkyrie.language.psi_node.ValkyrieModifiersNode
import com.intellij.icons.AllIcons
import com.intellij.ide.projectView.PresentationData
import com.intellij.ide.util.treeView.smartTree.TreeElement
import com.intellij.lang.ASTNode
import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import javax.swing.Icon

open class MixinModifier(node: ASTNode) : ViewableNode(node) {
    override fun getOriginalElement(): ValkyrieModifiersNode {
        return this as ValkyrieModifiersNode
    }
    override fun getIcon(flags: Int): Icon = ValkyrieIconProvider.MODIFIER
    override fun getNavigationElement(): PsiElement = this
    fun hasMutable(): Boolean {
        for (i in originalElement.children) {
            if (i.text == "mutable" || i.text == "mut") {
                return true
            }
        }
        return false
    }

    override fun getPresentation(): PresentationData {
        return PresentationData("[MODIFIERS]", "", this.getIcon(0), null)
    }

    override fun getChildrenView(): Array<ValkyrieViewElement> {
        return arrayOf()
    }
}

