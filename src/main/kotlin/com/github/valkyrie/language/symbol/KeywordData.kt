package com.github.valkyrie.language.symbol

import com.github.valkyrie.ide.doc.DocumentationRenderer
import com.github.valkyrie.ide.highlight.ValkyrieHighlightColor
import com.github.valkyrie.language.psi.ValkyrieTypes
import com.intellij.psi.PsiElement
import com.intellij.psi.tree.IElementType
import com.intellij.psi.util.elementType

class KeywordData(
    val name: String,
    private val detail: String = "",
) {
    fun documentation(doc: DocumentationRenderer) {
        doc.append(ValkyrieHighlightColor.KEYWORD, "keyword ")
        doc.append(ValkyrieHighlightColor.SYM_MACRO, name)
        doc.append("<hr/>")
        doc.append(detail)
    }


    companion object {
        fun builtinData(name: PsiElement): KeywordData? = when (name.elementType) {
            ValkyrieTypes.KW_CLASS -> KeywordData(
                "class",
                """
                class A()
                """.trimIndent()
            )
            ValkyrieTypes.KW_TRAIT -> KeywordData(
                "trait",
                """
                trait A()
                """.trimIndent()
            )
            else -> null
        }
    }
}