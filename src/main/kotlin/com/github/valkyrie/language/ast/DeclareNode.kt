package com.github.valkyrie.language.ast


import com.github.valkyrie.ide.view.ValkyrieViewElement
import com.intellij.ide.util.treeView.smartTree.TreeElement
import com.intellij.lang.ASTNode
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import com.intellij.psi.util.PsiTreeUtil
import javax.swing.Icon

/// 一定是可以 view 的节点
/// PsiSymbolDeclarationProvider,
@Suppress("UnstableApiUsage")
abstract class DeclareNode(node: ASTNode) : ValkyrieElement(node),
    PsiNameIdentifierOwner {
    abstract override fun getOriginalElement(): PsiElement;
    abstract override fun getNameIdentifier(): PsiElement
    abstract override fun getIcon(flags: Int): Icon;
    override fun getElementIcon(flags: Int): Icon = this.getIcon(flags)
    override fun getName(): String = this.nameIdentifier.text
    override fun getNavigationElement(): PsiElement = this.nameIdentifier
    override fun getTextOffset(): Int = this.nameIdentifier.textOffset
    override fun getPresentation(): ItemPresentation {
        return PresentationData(this.name, this.type)
    }

    open fun getChildrenView(): Array<TreeElement> {
        // TODO: modifier buffer
        val childrenView: MutableSet<ValkyrieViewElement> = mutableSetOf()
        for (item in PsiTreeUtil.getChildrenOfTypeAsList(this, NavigatablePsiElement::class.java)) {
            childrenView.add(ValkyrieViewElement(item))
        }
        return childrenView.toTypedArray()
    }
}

