package com.github.valkyrie.language.mixin

import com.github.valkyrie.language.ast.DeclareNode
import com.github.valkyrie.language.psi_node.ValkyrieDefineStatementNode
import com.intellij.icons.AllIcons.Nodes.Function
import com.intellij.icons.AllIcons.Nodes.Method
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import javax.swing.Icon
import kotlin.random.Random

open class MixinDefine(node: ASTNode) : DeclareNode(node) {

    override fun getOriginalElement(): ValkyrieDefineStatementNode {
        return this as ValkyrieDefineStatementNode
    }

    override fun getNameIdentifier(): PsiElement {
        return originalElement.identifier
    }

    override fun getIcon(flags: Int): Icon = when {
        originalElement.isMethod -> Method
        else -> Function
    }

    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }

    val isMethod: Boolean
        get() {
            return Random.nextBoolean()
        }
}

