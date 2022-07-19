package com.github.valkyrie.ide.highlight

import com.github.valkyrie.language.ast.hasModifier
import com.github.valkyrie.language.psi.ValkyriePatternItem
import com.github.valkyrie.language.psi.ValkyriePatternPair
import com.github.valkyrie.language.psi.ValkyrieIdentifier
import com.github.valkyrie.ide.highlight.ValkyrieHighlightColor as Color

enum class ValkyrieVariableHighlightMode {
    Local,
    Global,
    Argument,
    Self;

    private fun render(mut: Boolean) = when (this) {
        Local -> if (mut) Color.SYM_LOCAL_MUT else Color.SYM_LOCAL
        Global -> if (mut) Color.SYM_GLOBAL_MUT else Color.SYM_GLOBAL
        Argument -> if (mut) Color.SYM_ARG_MUT else Color.SYM_ARG
        Self -> if (mut) Color.SYM_FIELD else Color.SYM_ARG_SELF
    }

    fun highlightPatternItem(
        visitor: NodeHighlighter,
        o: ValkyriePatternItem,
        force_mut: Boolean = false,
    ) {
        this.highlightMaybeMutable(visitor, o.identifierList, force_mut,true)
        visitor.visitPatternItem(o)
    }

    fun highlightPatternPair(
        visitor: NodeHighlighter,
        o: ValkyriePatternPair,
        force_mut: Boolean = false,
    ) {
        this.highlightMaybeMutable(visitor, o.identifierList, force_mut,true)
        visitor.visitPatternPair(o)
    }

    fun highlightMaybeMutable(
        visitor: NodeHighlighter,
        symbols: List<ValkyrieIdentifier>,
        force_mut: Boolean,
        skip_last: Boolean,
    ) {
        val mutable = when (force_mut) {
            true -> true
            false -> hasModifier(symbols, "mut", skip_last)
        }
        var first = true;
        for (symbol in symbols.reversed()) {
            if (first) {
                first = false
                visitor.highlight(symbol, this.render(mutable))
            } else {
                visitor.highlight(symbol, Color.KEYWORD)
            }
        }
    }
}




