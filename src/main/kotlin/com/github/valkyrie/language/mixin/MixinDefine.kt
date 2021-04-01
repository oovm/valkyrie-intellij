package com.github.valkyrie.language.mixin

import com.github.valkyrie.language.ast.DeclareNode
import com.github.valkyrie.language.psi.ValkyrieDefStatement
import com.intellij.icons.AllIcons.Nodes.Function
import com.intellij.icons.AllIcons.Nodes.Method
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import javax.swing.Icon
import kotlin.random.Random

abstract class MixinDefine(node: ASTNode) : DeclareNode(node),
    ValkyrieDefStatement {
    override val viewIcon: Icon? = when {
        this.isMethod -> Method
        else -> Function
    }

    override fun getNameIdentifier(): PsiElement? {
        return this.modifierSymbols.lastChild
    }

    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }
}

