package com.github.valkyrie.language.ast

import com.github.valkyrie.language.psi.ValkyrieTypes.COMMENT
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiDocCommentBase
import com.intellij.psi.tree.IElementType

abstract class DocumentNode(node: ASTNode) : ValkyrieElement(node),
    PsiDocCommentBase {
    override fun getTokenType(): IElementType = COMMENT
}