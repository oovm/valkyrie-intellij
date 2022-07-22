package com.github.valkyrie.ide.highlight


import com.github.valkyrie.ide.file.ValkyrieFileNode
import com.github.valkyrie.language.ast.isMutable
import com.github.valkyrie.language.psi.*
import com.github.valkyrie.language.psi_node.ValkyrieDefineStatementNode
import com.intellij.codeInsight.daemon.impl.HighlightInfo
import com.intellij.codeInsight.daemon.impl.HighlightInfoType
import com.intellij.codeInsight.daemon.impl.HighlightVisitor
import com.intellij.codeInsight.daemon.impl.analysis.HighlightInfoHolder
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.github.valkyrie.ide.highlight.ValkyrieHighlightColor as Color

class NodeHighlighter : ValkyrieVisitor(), HighlightVisitor {
    private var infoHolder: HighlightInfoHolder? = null

    override fun visitNamespaceStatement(o: ValkyrieNamespaceStatement) {
        highlight(o.kwNamespace, Color.KEYWORD)
    }

    override fun visitImportStatement(o: ValkyrieImportStatement) {
        highlight(o.kwImport, Color.KEYWORD)
    }

    override fun visitImportItem(o: ValkyrieImportItem) {
        //TODO: get real symbol color
    }

    override fun visitNormalPattern(o: ValkyrieNormalPattern) {
        val mut = o.isMutable();
        val mode = ValkyrieVariableHighlightMode.Local;
        highlightSymbolList(o.identifierList, Color.KEYWORD)
//        o.patternItemList.forEach {
//            mode.highlightPatternItem(this, it, mut)
//        }
//        o.patternPairList.forEach {
//            mode.highlightPatternPair(this, it, mut)
//        }
    }

    override fun visitCasePattern(o: ValkyrieCasePattern) {
        visitCasePattern(o, ValkyrieVariableHighlightMode.Local, false)
    }

    private fun visitCasePattern(o: ValkyrieCasePattern, mode: ValkyrieVariableHighlightMode, force_mut: Boolean) {
        o.namepath?.let {
            highlight(it.lastChild, Color.SYM_CLASS)
        }
//        o.patternTuple?.let {
//            this.visitPatternTuple(it, mode, force_mut)
//        }
        super.visitCasePattern(o)
    }

    override fun visitDefineStatement(o: ValkyrieDefineStatement) {
        val node = o as ValkyrieDefineStatementNode;
        highlight(o.kwDefine, Color.KEYWORD)
        highlight(node.nameIdentifier, node.kind.color)
    }

    override fun visitDefineItem(o: ValkyrieDefineItem) {
//        highlight(o.symbol, o.symbolColor)
//        highlightModifiers(o.modifiers)
    }


    override fun visitForallStatement(o: ValkyrieForallStatement) {
//        o.identifierList.forEach {
//            highlight(it, Color.SYM_GENERIC)
//        }
//        super.visitForallStatement(o)
    }

    override fun visitClassStatement(o: ValkyrieClassStatement) {
        highlight(o.kwClass, Color.KEYWORD)
        highlight(o.identifier, Color.SYM_CLASS)
    }

//    override fun visitClassBraceItem(o: ValkyrieClassBraceItem) {
//        o.modifierSymbols?.let { highlightSymbolList(it.identifierList, Color.SYM_FIELD) }
//        super.visitClassBraceItem(o)
//    }
//
//    override fun visitClassNumericKey(o: ValkyrieClassNumericKey) {
//        o.modifierSymbols?.let { highlightSymbolList(it.identifierList, Color.KEYWORD) }
//        super.visitClassNumericKey(o)
//    }

    override fun visitTraitStatement(o: ValkyrieTraitStatement) {
//        highlight(o.symbol, Color.SYM_TRAIT)
//        highlightModifiers(o.modifiers)
    }

    override fun visitExtendsStatement(o: ValkyrieExtendsStatement) {
        highlight(o.kwExtends, Color.KEYWORD)
    }

    override fun visitTaggedStatement(o: ValkyrieTaggedStatement) {
//        highlight(o.symbol, Color.SYM_CLASS)
//        highlightModifiers(o.modifiers)
    }

    override fun visitTaggedItem(o: ValkyrieTaggedItem) {
        highlight(o.identifier, Color.SYM_VARIANT)
    }

    override fun visitBitflagStatement(o: ValkyrieBitflagStatement) {
//        highlight(o.symbol, Color.SYM_CLASS)
//        highlightModifiers(o.modifiers)
    }

    override fun visitBitflagItem(o: ValkyrieBitflagItem) {
        highlight(o.identifier, Color.SYM_VARIANT)
    }

    override fun visitMacro(o: ValkyrieMacro) {
        highlight(o.firstChild, Color.SYM_MACRO)
        for (i in o.namepathFree.identifierList) {
            highlight(i, Color.SYM_MACRO)
        }
    }

    override fun visitModifiers(o: ValkyrieModifiers) {
        o.identifierList.forEach {
            highlight(it, Color.MODIFIER)
        }
    }

    // TODO: real syntax resolve
    override fun visitIdentifier(o: ValkyrieIdentifier) {
        highlightWithText(o)
    }

    override fun visitObjectKey(o: ValkyrieObjectKey) {
        when (o.text) {
            "get", "set" -> {
                highlight(o, Color.KEYWORD)
                return
            }
        }

        if (!o.text.first().isDigit()) {
            highlight(o, Color.SYM_FIELD)
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
            }
            else {
                highlight(symbol, rest)
            }
        }
    }

    fun highlight(element: PsiElement?, color: Color) {
        if (element == null) return
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

    override fun clone(): HighlightVisitor = NodeHighlighter()

    override fun suitableForFile(file: PsiFile): Boolean = file is ValkyrieFileNode

    override fun visit(element: PsiElement) = element.accept(this)
}


private fun NodeHighlighter.highlightWithText(o: PsiElement) {
    if (o.text.startsWith("_")) {
        highlight(o, Color.SYM_FIELD)
        return
    }
    else if (o.text.uppercase() == o.text) {
        if (o.text.length == 1) {
            highlight(o, Color.SYM_GENERIC)
        }
        else {
            highlight(o, Color.SYM_CONSTANT)
        }
        return
    }

    when (o.text) {
        "Default", "Debug", "Clone", "Copy", "Serialize", "Deserialize",
        "SemiGroup", "Monoid", "HKT", "Functor", "Shape"
        -> {
            highlight(o, Color.SYM_TRAIT)
        }
        "u8", "u16", "u32", "u64", "u128", "u256",
        "i8", "i16", "i32", "i64", "i128", "i256",
        "int", "bool", "str", "string", "f32", "f64", "char", "byte", "void"
        -> {
            highlight(o, Color.KEYWORD)
        }
        "get", "set", "value", "extends", "self"
        -> {
            highlight(o, Color.KEYWORD)
        }
        "_" -> {
            highlight(o, Color.SYM_GENERIC)
        }
        "map", "or" -> {
            highlight(o, Color.SYM_FUNCTION_SELF)
        }
        "unit", "default" -> {
            highlight(o, Color.SYM_FUNCTION_FREE)
        }
        "Point", "Ellipse", "Circle" -> {
            highlight(o, Color.SYM_CLASS)
        }
        "center", "minor_axis", "major_axis", "radius" -> {
            highlight(o, Color.SYM_FUNCTION_SELF)
        }
        "x", "y", "v" -> {
            highlight(o, Color.SYM_FIELD)
        }
        "Option", "Result", "Current", "Target" -> {
            highlight(o, Color.SYM_CLASS)
        }
        "None", "Some", "Success", "Failure" -> {
            highlight(o, Color.SYM_VARIANT)
        }
        else -> {}
    }
}
