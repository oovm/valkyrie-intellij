package com.github.valkyrie.language.mixin

import com.github.valkyrie.language.ast.ValkyrieASTBase
import com.intellij.lang.ASTNode

// PsiReference
open class MixinNumber(node: ASTNode) : ValkyrieASTBase(node) {
    fun getStringText(): String {
        return this.children.reversed()[2].text
    }
}

