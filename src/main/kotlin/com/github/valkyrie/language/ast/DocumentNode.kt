package com.github.valkyrie.language.ast

import com.github.valkyrie.language.psi.ValkyrieTypes.COMMENT
import com.intellij.psi.PsiComment
import com.intellij.psi.PsiDocCommentBase
import com.intellij.psi.PsiElement
import com.intellij.psi.tree.IElementType

class DocumentNode(comment: PsiComment, rawText: String? = null) : ValkyrieElement(comment.node),
    PsiDocCommentBase {

    private val documentText: String

    init {
        print(rawText)
        this.documentText = rawText?.trimIndent() ?: "[PARSE_FAILED]: ${comment.text}"
    }

    override fun getTokenType(): IElementType = COMMENT
    override fun getOwner(): PsiElement? {
        TODO("Not yet implemented")
    }

    fun render(): String {
        print(documentText)
        return documentText
    }

    companion object {
        fun tryBuild(comment: PsiElement): DocumentNode? = when (comment) {
            is PsiComment -> tryBuild(comment)
            else -> null
        }
        fun tryBuild(node: PsiComment): DocumentNode? {
            val comment = """(#{3,})(\^)([^\00]*?)(\1)""".toRegex()
            val match = comment.matchEntire(node.text) ?: return null
            return DocumentNode(node, match.groups[3]?.value)
        }
    }
}