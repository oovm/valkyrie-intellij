package com.github.valkyrie.language.mixin

import com.github.valkyrie.ide.view.ValkyrieViewElement
import com.github.valkyrie.language.ast.ValkyrieASTBase
import com.github.valkyrie.language.ast.addChildrenView
import com.github.valkyrie.language.psi_node.ValkyrieDefineItemNode
import com.github.valkyrie.language.psi_node.ValkyrieModifiersNode
import com.intellij.icons.AllIcons
import com.intellij.ide.projectView.PresentationData
import com.intellij.lang.ASTNode
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import com.intellij.psi.util.PsiTreeUtil
import javax.swing.Icon

open class MixinDefineItem(node: ASTNode) : ValkyrieASTBase(node), PsiNameIdentifierOwner {
    override fun getOriginalElement(): ValkyrieDefineItemNode {
        return this as ValkyrieDefineItemNode
    }

    override fun getNameIdentifier(): PsiElement? {
        val id = originalElement.identifier;
        return when {
            id == null -> null
            id.text == "self" -> null
            else -> id
        }
    }

    override fun getNavigationElement(): PsiElement {
        return nameIdentifier ?: this
    }

    override fun getTextOffset(): Int = when (val id = originalElement.identifier) {
        null -> super.getTextOffset()
        else -> id.textOffset
    }

    override fun getIcon(flags: Int): Icon = AllIcons.Nodes.Parameter
    override fun getName(): String? {
        return originalElement.identifier?.text ?: this.text
    }
    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }

    fun hasMutable(): Boolean {
        val mod = originalElement.modifiers ?: return false
        return (mod as ValkyrieModifiersNode).hasMutable()
    }

    override fun getPresentation(): ItemPresentation? {
        return PresentationData(name, null, getIcon(0), null)
    }

    override fun getChildrenView(): Array<ValkyrieViewElement> {
        val views: MutableList<ValkyrieViewElement> = mutableListOf()
        originalElement.modifiers.addChildrenView(views)
        return views.toTypedArray()
    }
}

