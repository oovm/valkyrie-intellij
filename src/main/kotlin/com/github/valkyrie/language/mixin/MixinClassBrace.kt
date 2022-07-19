package com.github.valkyrie.language.mixin

import com.github.valkyrie.language.ast.DeclareNode
import com.github.valkyrie.language.psi_node.ValkyrieClassBraceItemNode
import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import javax.swing.Icon

open class MixinClassBrace(node: ASTNode) : DeclareNode(node) {

    override fun getOriginalElement(): ValkyrieClassBraceItemNode {
        return this as ValkyrieClassBraceItemNode
    }

    override fun getIcon(flags: Int): Icon = AllIcons.Nodes.Field

    override fun getNameIdentifier(): PsiElement {
        val index = originalElement.classNumericKey;
        return when {
            index != null -> index.lastChild
            else -> this.originalElement
        }
    }


    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }
}

