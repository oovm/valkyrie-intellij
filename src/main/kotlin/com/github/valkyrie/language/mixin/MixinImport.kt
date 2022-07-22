@file:Suppress("UnstableApiUsage")

package com.github.valkyrie.language.mixin

import com.github.valkyrie.ide.file.ValkyrieIconProvider
import com.github.valkyrie.ide.view.ValkyrieViewElement
import com.github.valkyrie.language.ast.ValkyrieASTBase
import com.github.valkyrie.language.psi_node.ValkyrieImportStatementNode
import com.github.valkyrie.language.symbol.ImportData
import com.intellij.lang.ASTNode
import com.intellij.model.psi.PsiCompletableReference
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.PsiReference
import com.intellij.psi.search.GlobalSearchScope
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

    override fun getReference(): PsiReference? {
        return when {
            references.count() != 1 -> null
            else -> references.first()
        }
    }

    override fun getReferences(): Array<PsiReference> {
        return  ownReferences.map { it as PsiReference }.toTypedArray()
    }

    override fun getOwnDeclarations(): MutableCollection<out ImportData> {
        return mutableListOf()
    }

    override fun getOwnReferences(): MutableCollection<out PsiCompletableReference> {
        return mutableListOf()
    }
}

