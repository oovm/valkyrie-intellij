package com.github.valkyrie.language.mixin

import com.github.valkyrie.ide.highlight.ValkyrieHighlightColor
import com.github.valkyrie.language.ast.DeclareNode
import com.github.valkyrie.language.psi.ValkyrieDefItem
import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import javax.swing.Icon

abstract class MixinDefineItem(node: ASTNode) : DeclareNode(node),
    ValkyrieDefItem {
    override val viewIcon: Icon = AllIcons.Nodes.Parameter

    override fun getNameIdentifier(): PsiElement? = this.symbol

    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }
}

