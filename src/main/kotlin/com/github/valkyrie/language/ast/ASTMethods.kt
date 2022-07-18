package com.github.valkyrie.language.ast


import com.github.valkyrie.ide.highlight.ValkyrieHighlightColor
import com.github.valkyrie.language.psi.*
import com.github.valkyrie.language.psi_node.ValkyrieIdentifierNode
import kotlin.random.Random

class ASTMethods {
    companion object {

        @JvmStatic
        fun getSymbol(node: ValkyrieClassStatement): ValkyrieIdentifier {
            return node.modifierSymbols.lastChild as ValkyrieIdentifier
        }

        @JvmStatic
        fun getSymbol(node: ValkyrieTraitStatement): ValkyrieIdentifier {
            return node.modifierSymbols.lastChild as ValkyrieIdentifier
        }

        @JvmStatic
        fun getSymbol(node: ValkyrieExtendsStatement): ValkyrieIdentifier {
            return node.modifierSymbols.lastChild as ValkyrieIdentifier
        }

        @JvmStatic
        fun getSymbol(node: ValkyrieTaggedStatement): ValkyrieIdentifier {
            return node.modifierSymbols.lastChild as ValkyrieIdentifier
        }

        @JvmStatic
        fun getSymbol(node: ValkyrieBitflagStatement): ValkyrieIdentifier {
            return node.modifierSymbols.lastChild as ValkyrieIdentifier
        }

        @JvmStatic
        fun getSymbol(node: ValkyrieDefStatement): ValkyrieIdentifier {
            return node.modifierSymbols.lastChild as ValkyrieIdentifier
        }

        @JvmStatic
        fun getSymbol(node: ValkyrieDefItem): ValkyrieIdentifier = when {
            node.identifier != null -> node.identifier!!
            node.defItemSign != null -> ValkyrieIdentifierNode(node.node)
            else -> node.modifierSymbols!!.lastChild as ValkyrieIdentifier
        }


        /// ----------------------------------------------------------------------------
        @JvmStatic
        fun getModifiers(node: ValkyrieClassStatement): Array<ValkyrieIdentifier> {
            return extractModifiers(node.modifierSymbols)
        }

        @JvmStatic
        fun getModifiers(node: ValkyrieTraitStatement): Array<ValkyrieIdentifier> {
            return extractModifiers(node.modifierSymbols)
        }

        @JvmStatic
        fun getModifiers(node: ValkyrieExtendsStatement): Array<ValkyrieIdentifier> {
            return extractModifiers(node.modifierSymbols)
        }

        @JvmStatic
        fun getModifiers(node: ValkyrieTaggedStatement): Array<ValkyrieIdentifier> {
            return extractModifiers(node.modifierSymbols)
        }

        @JvmStatic
        fun getModifiers(node: ValkyrieBitflagStatement): Array<ValkyrieIdentifier> {
            return extractModifiers(node.modifierSymbols)
        }

        @JvmStatic
        fun getModifiers(node: ValkyrieDefStatement): Array<ValkyrieIdentifier> {
            return extractModifiers(node.modifierSymbols)
        }

        @JvmStatic
        fun getModifiers(node: ValkyrieDefItem): Array<ValkyrieIdentifier> = when {
            node.identifier != null -> {
                val mods = node.modifierSymbols;
                when {
                    mods != null -> extractModifiers(mods)
                    else -> arrayOf()
                }
            }
            else -> extractModifiers(node.modifierSymbols)
        }

        /// ----------------------------------------------------------------------------
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

        /// ----------------------------------------------------------------------------
        @JvmStatic
        fun isMethod(node: ValkyrieDefStatement): Boolean {
            return Random.nextBoolean()
        }
        @JvmStatic
        fun getSymbolColor(node: ValkyrieDefItem): ValkyrieHighlightColor {
            when (node.text) {
                "self" -> return ValkyrieHighlightColor.SYM_ARG_SELF
                "<", ">", "<>" -> return ValkyrieHighlightColor.OPERATION_SIGN
                else -> {}
            }
            for (modifier in node.modifiers) {
                if (modifier.text == "mut") {
                    return when (node.symbol.text) {
                        "self" -> ValkyrieHighlightColor.SYM_ARG_SELF_MUT
                        else -> ValkyrieHighlightColor.SYM_ARG_MUT
                    }
                }
            }
            return ValkyrieHighlightColor.SYM_ARG
        }
    }
}

private fun extractModifiers(node: ValkyrieModifierSymbols?): Array<ValkyrieIdentifier> {
    if (node == null) return arrayOf()
    val out = mutableListOf<ValkyrieIdentifier>()
    node.children.forEach {
        out.add(it as ValkyrieIdentifier)
    }
    out.removeLastOrNull();
    return out.toTypedArray()
}