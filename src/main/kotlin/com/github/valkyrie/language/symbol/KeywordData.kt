package com.github.valkyrie.language.symbol

import com.github.valkyrie.ide.doc.DocumentationRenderer
import com.github.valkyrie.ide.highlight.ValkyrieHighlightColor
import com.github.valkyrie.language.psi.ValkyrieTypes
import com.intellij.psi.tree.IElementType

class KeywordData(
    val name: String,
    private val detail: String = "",
) {
    fun documentation(doc: DocumentationRenderer) {
        doc.append(ValkyrieHighlightColor.KEYWORD, "keyword ")
        doc.append(ValkyrieHighlightColor.MODIFIER, name)
        doc.append("<br/>")
        doc.append(detail)
    }


    companion object {
        fun getData(name: IElementType?): KeywordData? = when (name) {
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

        fun getData(name: String): Boolean = Database.containsKey(name)

        val Database: Map<String, KeywordData> = mapOf(
            "class" to ,
            "trait" to KeywordData("trait"),
            "interface" to KeywordData("interface"),
            "extends" to KeywordData(
                "extends",
                """
                extends Point {
                    def eq(self, other: Self) -> bool { }
                }
                """.trimIndent()
            ),

            "let" to KeywordData(
                "let",
                """
                let x = 1
                """.trimIndent()
            ),
            "def"
        )
    }
}