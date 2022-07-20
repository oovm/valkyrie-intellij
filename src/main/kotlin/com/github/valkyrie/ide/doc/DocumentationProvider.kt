package com.github.valkyrie.ide.doc

import com.github.valkyrie.language.psi.ValkyrieTypes.*
import com.intellij.lang.documentation.CodeDocumentationProvider
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.util.Pair
import com.intellij.psi.*
import com.intellij.psi.util.elementType


class DocumentationProvider : CodeDocumentationProvider {
    override fun generateDoc(element: PsiElement?, originalElement: PsiElement?): String? {
        return element?.let { DocumentationRenderer(it, originalElement).onDetail() }
    }

    override fun generateRenderedDoc(comment: PsiDocCommentBase): String? {
        TODO("generateRenderedDoc: $comment")
    }

    // 按住 Ctrl 后悬浮
    override fun getQuickNavigateInfo(element: PsiElement?, originalElement: PsiElement?): String? {
        return originalElement?.let { this.generateHoverDoc(it, originalElement) }
    }

    // 悬浮
    override fun generateHoverDoc(element: PsiElement, originalElement: PsiElement?): String {
        return DocumentationRenderer(element, originalElement).onHover()
    }

    override fun findExistingDocComment(contextElement: PsiComment?): PsiComment? {
        TODO("Not yet implemented")
    }

    override fun parseContext(startPoint: PsiElement): Pair<PsiElement, PsiComment>? {
        TODO("Not yet implemented")
    }

    override fun generateDocumentationContentStub(contextComment: PsiComment?): String? {
        TODO("Not yet implemented")
    }

    override fun getCustomDocumentationElement(editor: Editor, file: PsiFile, contextElement: PsiElement?, targetOffset: Int): PsiElement? {
        when (contextElement.elementType) {
            KW_CLASS, KW_MODIFIER, KW_DEFINE -> {
                return contextElement
            }
            TokenType.WHITE_SPACE -> {
                return null
            }
            else -> {
                print(editor)
                print(file)
                print(contextElement)
            }
        }

        return super.getCustomDocumentationElement(editor, file, contextElement, targetOffset)
    }
}