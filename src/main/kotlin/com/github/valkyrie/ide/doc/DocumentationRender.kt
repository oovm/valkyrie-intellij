package com.github.valkyrie.ide.doc

import com.github.valkyrie.ValkyrieLanguage
import com.github.valkyrie.ide.highlight.ValkyrieHighlightColor
import com.github.valkyrie.ide.highlight.ValkyrieHighlightColor.*
import com.github.valkyrie.language.psi.ValkyrieTypes
import com.github.valkyrie.language.psi_node.ValkyrieClassStatementNode
import com.github.valkyrie.language.psi_node.ValkyrieTraitStatementNode
import com.intellij.openapi.editor.colors.EditorColorsManager
import com.intellij.openapi.editor.richcopy.HtmlSyntaxInfoUtil
import com.intellij.psi.PsiElement
import com.intellij.psi.util.elementType
import com.intellij.ui.ColorUtil


class DocumentationRender(var element: PsiElement, private var original: PsiElement?) {
    private val doc = StringBuilder()
    fun onHover(): String {
        when (element) {
            is ValkyrieTraitStatementNode -> buildShort(element as ValkyrieTraitStatementNode)
            is ValkyrieClassStatementNode -> buildShort(element as ValkyrieClassStatementNode)
            else -> doc.append("onHover: ${element.text}")
        }
        return doc.toString()
    }

    fun onDetail(): String {
        when (element.elementType) {
            ValkyrieTypes.EXTENDS -> appendExtends()
            else -> {}
        }
        when (element) {
            is ValkyrieTraitStatementNode -> buildDetail(element as ValkyrieTraitStatementNode)
            is ValkyrieClassStatementNode -> buildShort(element as ValkyrieClassStatementNode)
            else -> {
                doc.append(element)
                doc.append("<br/>")
                doc.append(original)
                doc.append("<br/>")
                doc.append("onDetail: ${element.text}")
            }
        }
        return doc.toString()
    }

    private fun buildShort(element: ValkyrieTraitStatementNode) {
        append(KEYWORD, "crate ")
        appendNamespace()
        doc.append("<br/>")
        append(KEYWORD, "public ")
        append(KEYWORD, "native ")
        append(KEYWORD, "trait ")
        append(SYM_TRAIT, element.name)
    }

    private fun buildDetail(element: ValkyrieTraitStatementNode) {
        this.buildShort(element)
    }

    private fun buildShort(element: ValkyrieClassStatementNode) {
        append(KEYWORD, "crate ")
        appendNamespace()
        doc.append("<br/>")
        append(KEYWORD, "public ")
        append(KEYWORD, "native ")
        append(KEYWORD, "class ")
        append(SYM_CLASS, element.name)
//        appendNewline()
//        append(KEYWORD, "implements ")
//        append(SYM_TRAIT, "Eq")
//        appendAdd()
//        append(SYM_TRAIT, "Hash")
    }


    /// get the path relative to the project root
    /// FIXME: get real declare module
    private fun appendNamespace() {
        val file = element.containingFile;
        // fake module path
        val path = file.virtualFile.path.substringAfter("src/").replace("/", "::").replace(".vk", "")
        append(path)
    }

    private fun append(text: String) {
        doc.append("<span>${text}</span>")
    }

    private fun append(key: ValkyrieHighlightColor, text: String) {
        // HtmlSyntaxInfoUtil.getStyledSpan(key.textAttributesKey, text, 1.0f)
        val attr = EditorColorsManager.getInstance().globalScheme.getAttributes(key.textAttributesKey)
        val color = ColorUtil.toHtmlColor(attr.foregroundColor)
        doc.append("<span style='color:${color}'>${text}</span>")
    }

    private fun appendHighlight(code: String) {
        HtmlSyntaxInfoUtil.appendHighlightedByLexerAndEncodedAsHtmlCodeSnippet(
            doc,
            element.project,
            ValkyrieLanguage,
            code.trimIndent(),
            1.0f,
        )
    }

    private fun appendAdd() {
        doc.append("<span>+</span>")
    }


    private fun appendExtends() {
        append(ValkyrieHighlightColor.KEYWORD, "keyword ")
        append(ValkyrieHighlightColor.SYM_MACRO, "extends")
        doc.append("<hr/>")
        appendHighlight(
            """
        extends Point {
            def eq(self, other: Self) -> bool { }
        }
        """
        )

    }
}


