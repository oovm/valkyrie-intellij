package com.github.valkyrie.ide.matcher


import com.github.valkyrie.language.psi.*
import com.intellij.lang.folding.FoldingDescriptor
import com.intellij.psi.PsiElement

class ValkyrieFoldingVisitor(private val descriptors: MutableList<FoldingDescriptor>) : ValkyrieRecursiveVisitor() {

//    override fun visitInlinePlaceable(o: FluentInlinePlaceable) {
//        descriptors += FoldingDescriptor(o.node, TextRange(o.firstChild.endOffset, o.lastChild.startOffset))
//        super.visitInlinePlaceable(o)
//    }
//
//    override fun visitMessage(o: FluentMessage) {
//        //TODO: folding end of =
//        super.visitMessage(o)
//    }



    private fun fold(element: PsiElement) {
        descriptors += FoldingDescriptor(element.node, element.textRange)
    }
}