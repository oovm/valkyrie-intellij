package com.github.valkyrie.language.mixin

import com.github.valkyrie.language.ast.ValkyrieASTBase
import com.github.valkyrie.language.psi.ValkyrieTypeStatement
import com.intellij.icons.AllIcons
import com.intellij.ide.projectView.PresentationData
import com.intellij.lang.ASTNode
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.NavigatablePsiElement

abstract class MixinType(node: ASTNode) : ValkyrieASTBase(node),
    NavigatablePsiElement,
    ValkyrieTypeStatement {
    override fun getPresentation(): ItemPresentation = PresentationData(
        this.identifier.text,
        "",
        AllIcons.Nodes.Type,
        null
    )
}

