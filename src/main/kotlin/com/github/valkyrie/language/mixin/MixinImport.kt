package com.github.valkyrie.language.mixin

import com.github.valkyrie.language.ast.ValkyrieElement
import com.github.valkyrie.language.ast.ViewableNode
import com.github.valkyrie.language.psi.ValkyrieImportStatement
import com.github.valkyrie.language.psi.ValkyriePresentationItem
import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.PsiElement
import javax.swing.Icon

open class MixinImport(node: ASTNode) : ViewableNode(node),
    ValkyrieImportStatement {
    override val viewIcon: Icon?
        get() = TODO("Not yet implemented")

    override fun getNavigationElement(): PsiElement {
        TODO("Not yet implemented")
    }

    override fun getPresentation(): ItemPresentation = ValkyriePresentationItem(
        "imports",
        AllIcons.Nodes.Class
    )

    override fun getOriginalElement(): PsiElement {
        TODO("Not yet implemented")
    }
}

