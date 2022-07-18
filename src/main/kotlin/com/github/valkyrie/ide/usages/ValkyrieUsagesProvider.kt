package com.github.valkyrie.ide.usages

import com.github.valkyrie.language.lexer.ValkyrieLexerAdapter
import com.github.valkyrie.language.psi.ValkyrieTypes
import com.intellij.lang.cacheBuilder.DefaultWordsScanner
import com.intellij.lang.cacheBuilder.WordsScanner
import com.intellij.lang.findUsages.FindUsagesProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.tree.TokenSet

class ValkyrieUsagesProvider : FindUsagesProvider {
    override fun getWordsScanner(): WordsScanner {
        return DefaultWordsScanner(
            ValkyrieLexerAdapter(),
            TokenSet.create(ValkyrieTypes.SYMBOL_XID),
            TokenSet.create(ValkyrieTypes.SYMBOL_RAW),
            TokenSet.create(ValkyrieTypes.COMMENT),
            TokenSet.EMPTY
        )
    }

    override fun canFindUsagesFor(psiElement: PsiElement): Boolean {
       // return psiElement is PsiNamedElement
        return true
    }

    override fun getHelpId(psiElement: PsiElement): String {
        return "getHelpId"
    }

    override fun getType(element: PsiElement): String {
        return "getType"
    }

    override fun getDescriptiveName(element: PsiElement): String {
        return "getDescriptiveName"
    }

    override fun getNodeText(element: PsiElement, useFullName: Boolean): String {
        return "getNodeText"
    }
}