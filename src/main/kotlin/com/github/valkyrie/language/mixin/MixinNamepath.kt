package com.github.valkyrie.language.mixin

import com.github.valkyrie.language.ast.ViewableNode
import com.github.valkyrie.language.psi_node.ValkyrieNamespaceNode
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import javax.swing.Icon

open class MixinNamepath(node: ASTNode) : ViewableNode(node) {
    override fun getOriginalElement(): ValkyrieNamespaceNode {
        return this as ValkyrieNamespaceNode
    }

    override fun getIcon(flags: Int): Icon {
        TODO("Not yet implemented")
    }

    override fun getNavigationElement(): PsiElement {
        TODO("Not yet implemented")
    }

}

