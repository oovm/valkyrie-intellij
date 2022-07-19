package com.github.valkyrie.language.mixin

import com.github.valkyrie.language.ast.DeclareNode
import com.github.valkyrie.language.ast.ViewableNode
import com.github.valkyrie.language.psi_node.ValkyrieDefineItemNode
import com.github.valkyrie.language.psi_node.ValkyrieModifiersNode
import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import javax.swing.Icon

open class MixinModifier(node: ASTNode) : ViewableNode(node) {
    override fun getOriginalElement(): ValkyrieModifiersNode {
        return this as ValkyrieModifiersNode
    }
    override fun getIcon(flags: Int): Icon = AllIcons.Nodes.Parameter
    override fun getNavigationElement(): PsiElement = this

    fun hasMutable(): Boolean {
        for (i in originalElement.children) {
            if (i.text == "mutable") {
                return true
            }
        }
        return false
    }
}

