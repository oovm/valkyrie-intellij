package com.github.valkyrie.language.mixin

import com.github.valkyrie.ide.view.ValkyrieViewElement
import com.github.valkyrie.language.ast.DeclareNode
import com.github.valkyrie.language.psi.ValkyrieExtendsStatement
import com.github.valkyrie.language.psi.ValkyriePresentationItem
import com.github.valkyrie.language.psi.ValkyrieTaggedItem
import com.intellij.icons.AllIcons
import com.intellij.ide.util.treeView.smartTree.TreeElement
import com.intellij.lang.ASTNode
import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import javax.swing.Icon

abstract class MixinExtends(node: ASTNode) : DeclareNode(node),
    ValkyrieExtendsStatement {
    override fun getNameIdentifier(): PsiElement = this.symbol

    override val viewIcon: Icon = AllIcons.Nodes.EntryPoints

    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }
    override fun addChildrenView(childrenView: MutableSet<ValkyrieViewElement>) {
        PsiTreeUtil.getChildrenOfTypeAsList(
            this.traitBlock,
            NavigatablePsiElement::class.java
        ).forEach {
            childrenView.add(ValkyrieViewElement(it))
        }
    }
}

