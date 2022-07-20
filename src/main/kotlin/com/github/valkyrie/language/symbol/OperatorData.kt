package com.github.valkyrie.language.symbol

import com.github.valkyrie.ide.doc.DocumentationRenderer
import com.github.valkyrie.ide.highlight.ValkyrieHighlightColor
import com.github.valkyrie.language.psi.ValkyrieTypes
import com.intellij.psi.PsiElement
import com.intellij.psi.util.elementType

@Suppress("MemberVisibilityCanBePrivate")
class OperatorData(
    val name: String,
    val symbol: String,
    val detail: String = "",
    val associative: OperatorAssociativity = OperatorAssociativity.NONE,
    val priority: Int = 100
) {
    fun documentation(doc: DocumentationRenderer) {
        doc.append(ValkyrieHighlightColor.KEYWORD, "operator ")
        doc.append(ValkyrieHighlightColor.SYM_MACRO , symbol)
        doc.append(ValkyrieHighlightColor.KEYWORD, " de-sugars ")
        doc.append(ValkyrieHighlightColor.SYM_FUNCTION_FREE, name)
        doc.append("<br/>")
        doc.append(ValkyrieHighlightColor.KEYWORD, "associative ")
        doc.append(ValkyrieHighlightColor.SYM_MACRO , associative.toString())
        doc.append("<br/>")
        doc.append(ValkyrieHighlightColor.KEYWORD, "priority ")
        doc.append(ValkyrieHighlightColor.SYM_CONSTANT , priority.toString())
        doc.append("<hr/>")
        doc.append(detail)
    }

    companion object {
        fun builtinData(name: PsiElement): OperatorData? = when (name.elementType) {
            ValkyrieTypes.OP_ADD -> OperatorData(
                "add",
                "+",
                """
                a + b
                """.trimIndent()
            )
            ValkyrieTypes.OP_INC -> OperatorData(
                "++",
                "increase",
                """
                a ++ b
                ++a
                """.trimIndent()
            )
            else -> null
        }
    }
}