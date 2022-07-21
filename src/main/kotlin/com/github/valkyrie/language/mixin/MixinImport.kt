package com.github.valkyrie.language.mixin

import com.github.valkyrie.ide.file.ValkyrieIconProvider
import com.github.valkyrie.ide.view.ValkyrieViewElement
import com.github.valkyrie.language.ast.ValkyrieASTBase
import com.github.valkyrie.language.psi.ValkyrieImportStatement
import com.github.valkyrie.language.psi_node.ValkyrieImportStatementNode
import com.intellij.lang.ASTNode
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
}

