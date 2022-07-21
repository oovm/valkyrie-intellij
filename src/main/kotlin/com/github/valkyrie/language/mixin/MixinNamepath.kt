package com.github.valkyrie.language.mixin

import com.github.valkyrie.language.ast.ValkyrieASTBase
import com.github.valkyrie.language.psi.ValkyrieTypes
import com.github.valkyrie.language.psi_node.ValkyrieIdentifierNode
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.util.elementType

open class MixinNamepath(node: ASTNode) : ValkyrieASTBase(node) {
//    override fun getOriginalElement(): PsiElement = this
//    override fun getIcon(flags: Int): Icon {
//        TODO("Not yet implemented")
//    }
//
//    override fun getNavigationElement(): PsiElement {
//        TODO("Not yet implemented")
//    }

    override fun getName(): String? {
        return children
            .filterIsInstance<ValkyrieIdentifierNode>()
            .joinToString("∷") { it.name }
    }


    fun delimiterList(): List<PsiElement> {
        return this.children.filter {
            it.elementType == ValkyrieTypes.DOT || it.elementType == ValkyrieTypes.OP_PROPORTION
        }
    }
}

