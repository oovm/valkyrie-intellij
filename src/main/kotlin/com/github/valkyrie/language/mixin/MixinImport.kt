@file:Suppress("UnstableApiUsage")

package com.github.valkyrie.language.mixin

import com.github.valkyrie.ide.file.ValkyrieIconProvider
import com.github.valkyrie.ide.view.ValkyrieViewElement
import com.github.valkyrie.language.ast.ValkyrieASTBase
import com.github.valkyrie.language.psi_node.ValkyrieImportStatementNode
import com.github.valkyrie.language.symbol.ImportData
import com.intellij.lang.ASTNode
import com.intellij.model.psi.PsiSymbolDeclaration
import com.intellij.navigation.ItemPresentation
import javax.swing.Icon

open class MixinImport(node: ASTNode) : ValkyrieASTBase(node) {
    override fun getIcon(flags: Int): Icon = ValkyrieIconProvider.IMPORT
    override fun getOriginalElement(): ValkyrieImportStatementNode {
        return this as ValkyrieImportStatementNode
    }

    override fun getPresentation(): ItemPresentation? {
        return null
    }

    override fun getChildrenView(): Array<ValkyrieViewElement> {
        return arrayOf()
    }

    fun expandImports(): Map<String, Array<String>> {
        val imports = mutableMapOf<String, Array<String>>()
        val importStatement = this.originalElement.importItem


        return imports
    }

    fun resolveImports() {

    }

    override fun getOwnDeclarations(): MutableCollection<out ImportData> {
        return mutableListOf<ImportData>()
    }
}

