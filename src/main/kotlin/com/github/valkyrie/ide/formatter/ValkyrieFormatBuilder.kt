package com.github.valkyrie.ide.formatter

import com.intellij.formatting.*
import com.intellij.lang.ASTNode
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiFile

class ValkyrieFormatBuilder : FormattingModelBuilder {
    override fun getRangeAffectingIndent(file: PsiFile?, offset: Int, elementAtOffset: ASTNode?): TextRange? = null

    override fun createModel(formattingContext: FormattingContext): FormattingModel {
        val settings = formattingContext.codeStyleSettings
        val element = formattingContext.psiElement
        val ctx = ValkyrieFormatSpace.create(settings)
        val block = ValkyrieFormatBlock(element.node, null, Indent.getNoneIndent(), null, ctx)
        return FormattingModelProvider.createFormattingModelForPsiFile(element.containingFile, block, settings)
    }

    companion object {
        fun getChildAttributes(node: ASTNode, newChildIndex: Int): ChildAttributes {
            val indent = when (node.elementType) {
//                FluentTypes.SELECT_EXPRESSION -> Indent.getNormalIndent()
                else -> Indent.getNoneIndent()
            }
            return ChildAttributes(indent, null)
        }
    }
}
