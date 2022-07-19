package com.github.valkyrie.language.ast


import com.github.valkyrie.ide.highlight.ValkyrieHighlightColor
import com.github.valkyrie.language.psi.*
import com.github.valkyrie.language.psi_node.ValkyrieIdentifierNode
import kotlin.random.Random

class ASTMethods {
    companion object {

        @JvmStatic
        fun getBraceItemList(node: ValkyrieClassStatement): Array<ValkyrieClassBraceItem> {
            return arrayOf()
        }

        @JvmStatic
        fun getTupleItemList(node: ValkyrieClassStatement): Array<ValkyrieClassTupleItem> {
            return arrayOf()
        }

        @JvmStatic
        fun isEmpty(node: ValkyrieClassStatement): Boolean {
            return getBraceItemList(node).isEmpty() || getTupleItemList(node).isEmpty()
        }
    }
}