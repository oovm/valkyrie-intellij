package com.github.valkyrie.language.mixin

import com.github.valkyrie.language.ast.ValkyrieASTBase
import com.intellij.lang.ASTNode

open class MixinIdentifier(node: ASTNode) : ValkyrieASTBase(node) {
    override fun getName(): String {
        return this.text.trim('`')
    }
}
