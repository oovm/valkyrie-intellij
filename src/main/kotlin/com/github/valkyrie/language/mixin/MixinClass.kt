package com.github.valkyrie.language.mixin

import com.github.valkyrie.ide.view.ValkyrieViewElement
import com.github.valkyrie.language.ast.DeclareNode
import com.github.valkyrie.language.psi_node.ValkyrieClassStatementNode
import com.intellij.icons.AllIcons
import com.intellij.ide.util.treeView.smartTree.TreeElement
import com.intellij.lang.ASTNode
import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.PsiElement
import javax.swing.Icon

// PsiReference
open class MixinClass(node: ASTNode) : DeclareNode(node) {
    override fun getOriginalElement(): ValkyrieClassStatementNode {
        return this as ValkyrieClassStatementNode
    }

    override fun getNameIdentifier(): PsiElement = originalElement
    override fun getIcon(flags: Int): Icon = AllIcons.Nodes.Class

    override fun setName(name: String): PsiElement {
        return this.nameIdentifier
    }

    override fun getChildrenView(): Array<TreeElement> {
        val view = mutableListOf<TreeElement>()
//        for (it in originalElement.braceItemList) {
//            view.add(ValkyrieViewElement(it as NavigatablePsiElement))
//        }
//        for (it in originalElement.tupleItemList) {
//            view.add(ValkyrieViewElement(it as NavigatablePsiElement))
//        }
        return view.toTypedArray()
    }

}

