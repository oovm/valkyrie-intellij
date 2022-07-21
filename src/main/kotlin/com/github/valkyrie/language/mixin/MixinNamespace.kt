package com.github.valkyrie.language.mixin

import com.github.valkyrie.ide.file.ValkyrieIconProvider
import com.github.valkyrie.ide.view.ValkyrieViewElement
import com.github.valkyrie.language.ast.ViewableNode
import com.github.valkyrie.language.psi_node.ValkyrieNamespaceStatementNode
import com.intellij.ide.projectView.PresentationData
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import javax.swing.Icon

open class MixinNamespace(node: ASTNode) : ViewableNode(node), PsiNameIdentifierOwner {
    override fun getOriginalElement(): ValkyrieNamespaceStatementNode {
        return this as ValkyrieNamespaceStatementNode
    }

    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }

    override fun getNameIdentifier(): PsiElement? {
        return when {
            originalElement.kwNamespace.text.endsWith("!") -> {
                originalElement.namepathFree.lastChild
            }
            else -> {
                null
            }
        }
    }

    override fun getIcon(flags: Int): Icon {
        return ValkyrieIconProvider.NAMESPACE
    }

    override fun getNavigationElement(): PsiElement {
        return nameIdentifier ?: originalElement.namepathFree
    }

    override fun getTextOffset(): Int {
        return navigationElement.textOffset
    }

    override fun getPresentation(): PresentationData {
        return super.getPresentation()
    }

    override fun getChildrenView(): Array<ValkyrieViewElement> {
        return super.getChildrenView()
    }
}

