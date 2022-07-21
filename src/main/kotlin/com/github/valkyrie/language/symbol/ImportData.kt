@file:Suppress("ConvertSecondaryConstructorToPrimary", "MemberVisibilityCanBePrivate", "UnstableApiUsage")

package com.github.valkyrie.language.symbol

import com.github.valkyrie.language.psi_node.ValkyrieIdentifierNode
import com.intellij.model.Pointer
import com.intellij.model.Symbol
import com.intellij.model.psi.PsiSymbolDeclaration
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement


class ImportData : Symbol, Pointer<ImportData>, PsiSymbolDeclaration {
    val nav: ValkyrieIdentifierNode
    var name: String
    var namepath: Array<String>
    constructor(nav: ValkyrieIdentifierNode, name: String) {
        this.nav = nav
        this.name = name
        this.namepath = arrayOf()
    }
    constructor(nav: ValkyrieIdentifierNode, name: String, namepath: Array<String>) {
        this.nav = nav
        this.name = name
        this.namepath = namepath
    }

    override fun createPointer(): Pointer<out ImportData> = this
    override fun dereference(): ImportData = this
    override fun getDeclaringElement(): PsiElement = nav

    override fun getRangeInDeclaringElement(): TextRange = nav.textRange

    override fun getSymbol(): Symbol = this


    companion object {

    }


}