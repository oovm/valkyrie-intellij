package com.github.valkyrie.ide.highlight


import com.github.valkyrie.ide.file.ValkyrieFile
import com.github.valkyrie.language.ast.isMutable
import com.github.valkyrie.language.psi.*
import com.intellij.codeInsight.daemon.impl.HighlightInfo
import com.intellij.codeInsight.daemon.impl.HighlightInfoType
import com.intellij.codeInsight.daemon.impl.HighlightVisitor
import com.intellij.codeInsight.daemon.impl.analysis.HighlightInfoHolder
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.github.valkyrie.ide.highlight.ValkyrieHighlightColor as Color

class ValkyrieHighlightVisitor : ValkyrieVisitor(), HighlightVisitor {
    private var infoHolder: HighlightInfoHolder? = null

    override fun visitAs(o: ValkyrieAs) {
        highlight(o, Color.KEYWORD)
    }

//    override fun visitExportName(o: ValkyrieExportName) {
//        if (o.text.startsWith('@') || o.text.startsWith('#')) {
//            highlight(o, Color.SYM_MACRO)
//        }
//    }

    override fun visitNormalPattern(o: ValkyrieNormalPattern) {
        val mut = o.isMutable();
        val mode = ValkyrieVariableHighlightMode.Local;
        highlightSymbolList(o.identifierList, Color.KEYWORD)
        o.patternItemList.forEach {
            mode.highlightPatternItem(this, it, mut)
        }
        o.patternPairList.forEach {
            mode.highlightPatternPair(this, it, mut)
        }
    }

    override fun visitCasePattern(o: ValkyrieCasePattern) {
        visitCasePattern(o, ValkyrieVariableHighlightMode.Local, false)
    }

    private fun visitCasePattern(o: ValkyrieCasePattern, mode: ValkyrieVariableHighlightMode, force_mut: Boolean) {
        o.namespace?.let {
            highlight(it.lastChild, Color.SYM_CLASS)
        }
//        o.patternTuple?.let {
//            this.visitPatternTuple(it, mode, force_mut)
//        }
        super.visitCasePattern(o)
    }

    override fun visitDefStatement(o: ValkyrieDefStatement) {
        highlight(o.symbol, Color.SYM_FUNCTION_FREE)
        highlightModifiers(o.modifiers)
    }

    override fun visitDefItem(o: ValkyrieDefItem) {
        highlight(o.symbol, o.symbolColor)
        highlightModifiers(o.modifiers)
    }

    override fun visitForallStatement(o: ValkyrieForallStatement) {
        o.identifierList.forEach {
            highlight(it, Color.SYM_GENERIC)
        }
        super.visitForallStatement(o)
    }


    override fun visitClassStatement(o: ValkyrieClassStatement) {
        highlight(o.symbol, Color.SYM_CLASS)
        o.identifier?.let { highlight(it, Color.SYM_TRAIT) }
        highlightModifiers(o.modifiers)
    }

    override fun visitClassBraceItem(o: ValkyrieClassBraceItem) {
        o.modifierSymbols?.let { highlightSymbolList(it.identifierList, Color.SYM_FIELD) }
        super.visitClassBraceItem(o)
    }

    override fun visitClassNumericKey(o: ValkyrieClassNumericKey) {
        o.modifierSymbols?.let { highlightSymbolList(it.identifierList, Color.KEYWORD) }
        super.visitClassNumericKey(o)
    }

    override fun visitTraitStatement(o: ValkyrieTraitStatement) {
        highlight(o.symbol, Color.SYM_TRAIT)
        highlightModifiers(o.modifiers)
    }

    override fun visitExtendsStatement(o: ValkyrieExtendsStatement) {
        highlight(o.symbol, Color.SYM_TRAIT)
        highlightModifiers(o.modifiers)
    }

    override fun visitTaggedStatement(o: ValkyrieTaggedStatement) {
        highlight(o.symbol, Color.SYM_CLASS)
        highlightModifiers(o.modifiers)
    }

    override fun visitTaggedItem(o: ValkyrieTaggedItem) {
        highlight(o.identifier, Color.SYM_VARIANT)
        super.visitTaggedItem(o)
    }

    override fun visitBitflagStatement(o: ValkyrieBitflagStatement) {
        highlight(o.symbol, Color.SYM_CLASS)
        highlightModifiers(o.modifiers)
    }

    override fun visitBitflagItem(o: ValkyrieBitflagItem) {
        highlight(o.identifier, Color.SYM_VARIANT)
        super.visitBitflagItem(o)
    }

    // TODO: real syntax resolve
    override fun visitIdentifier(o: ValkyrieIdentifier) {
        // guess macro
        if (o.text.startsWith('@') || o.text.startsWith('#')) {
            return highlight(o, Color.SYM_MACRO)
        }
        when (o.text) {
            "Default", "Debug", "Clone", "Copy", "Serialize", "Deserialize",
            "SemiGroup", "Monoid", "HKT", "Functor",
            -> {
                highlight(o, Color.SYM_TRAIT)
            }
            "u8", "u16", "u32", "u64", "u128", "u256",
            "i8", "i16", "i32", "i64", "i128", "i256",
            "int", "bool", "str", "f32", "f64", "char", "byte", "void",
            -> {
                highlight(o, Color.KEYWORD)
            }
            "_", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" -> {
                highlight(o, Color.SYM_GENERIC)
            }
            "rhs", "f" -> {
                highlight(o, Color.SYM_ARG)
            }
            "map", "or" -> {
                highlight(o, Color.SYM_FUNCTION_SELF)
            }
            "unit", "default" -> {
                highlight(o, Color.SYM_FUNCTION_FREE)
            }
            "Option", "Result", "Current", "Target" -> {
                highlight(o, Color.SYM_CLASS)
            }
            "None", "Some" -> {
                highlight(o, Color.SYM_VARIANT)
            }
            else -> {}
        }
    }


    override fun visitNumber(o: ValkyrieNumber) {
        o.identifier?.let {
            highlight(it, Color.OP_NUMBER)
        }
    }

    override fun visitString(o: ValkyrieString) {
        o.identifier?.let {
            highlight(it, Color.OP_STRING)
        }
    }

    override fun visitBoolean(o: ValkyrieBoolean) {
        highlight(o, Color.KEYWORD)
    }

    // =================================================================================================================

    private fun highlightSymbolList(
        symbols: List<ValkyrieIdentifier>,
        last: Color,
        rest: Color = Color.KEYWORD,
    ) {
        var first = true;
        for (symbol in symbols.reversed()) {
            if (first) {
                first = false
                highlight(symbol, last)
            } else {
                highlight(symbol, rest)
            }
        }
    }

    private fun highlightModifiers(element: Array<ValkyrieIdentifier>?) {
        for (modifier in element ?: emptyArray()) {
            highlight(modifier, Color.KEYWORD)
        }
    }

    fun highlight(element: PsiElement, color: Color) {
        val builder = HighlightInfo.newHighlightInfo(HighlightInfoType.INFORMATION)
        builder.textAttributes(color.textAttributesKey)
        builder.range(element)

        infoHolder?.add(builder.create())
    }


    override fun analyze(
        file: PsiFile,
        updateWholeFile: Boolean,
        holder: HighlightInfoHolder,
        action: Runnable,
    ): Boolean {
        infoHolder = holder
        action.run()

        return true
    }

    override fun clone(): HighlightVisitor = ValkyrieHighlightVisitor()

    override fun suitableForFile(file: PsiFile): Boolean = file is ValkyrieFile

    override fun visit(element: PsiElement) = element.accept(this)
}