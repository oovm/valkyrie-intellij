package com.github.valkyrie.language.mixin

import com.github.valkyrie.language.ast.ViewableNode
import com.github.valkyrie.language.psi.ValkyrieTypes
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.util.elementType
import javax.swing.Icon

open class MixinNamepath(node: ASTNode) : ViewableNode(node) {
    override fun getOriginalElement(): PsiElement = this

    override fun getIcon(flags: Int): Icon {
        TODO("Not yet implemented")
    }

    override fun getNavigationElement(): PsiElement {
        TODO("Not yet implemented")
    }

    fun delimiterList(): List<PsiElement> {
        return this.children.filter {
            it.elementType == ValkyrieTypes.DOT || it.elementType == ValkyrieTypes.OP_PROPORTION
        }
    }
}

