package com.github.valkyrie.language.mixin

import com.github.valkyrie.language.ast.ValkyrieASTBase
import com.github.valkyrie.language.psi.ValkyrieIdentifier
import com.github.valkyrie.language.psi_node.ValkyrieIdentifierNode
import com.github.valkyrie.language.psi_node.ValkyrieImportItemNode
import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import javax.swing.Icon

open class MixinImportItem(node: ASTNode) : ValkyrieASTBase(node), PsiNameIdentifierOwner {
    override fun getIcon(flags: Int): Icon = AllIcons.Nodes.Class
    override fun getOriginalElement(): ValkyrieImportItemNode {
        return this as ValkyrieImportItemNode
    }

    override fun getNameIdentifier(): ValkyrieIdentifier? {
        return originalElement.identifier
    }

    override fun getTextOffset(): Int {
        return nameIdentifier?.textOffset ?: super.getTextOffset()
    }

    override fun getNavigationElement(): PsiElement {
        return nameIdentifier ?: originalElement
    }

    override fun getName(): String? {
        return nameIdentifier?.text
    }

    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }



    fun getNamepath(): Array<ValkyrieIdentifierNode> {
        return originalElement.namepathFree.identifierList.map { it as ValkyrieIdentifierNode }.toTypedArray()
    }

    fun isAlias(): Boolean {
        return originalElement.identifier != null
    }

    fun getIdentifierSymbol(): ValkyrieIdentifierNode? {
        if (originalElement.importBlock != null) {
            return null
        }
        return when (val id = originalElement.identifier) {
            null -> getNamepath().last()
            else -> id as ValkyrieIdentifierNode
        }
    }
}

