package com.github.valkyrie.language.mixin

import com.github.valkyrie.ide.view.ValkyrieViewElement
import com.github.valkyrie.language.ast.DeclareNode
import com.github.valkyrie.language.psi.ValkyriePresentationItem
import com.github.valkyrie.language.psi.ValkyrieTaggedItem
import com.github.valkyrie.language.psi_node.ValkyrieTaggedStatementNode
import com.intellij.icons.AllIcons
import com.intellij.ide.util.treeView.smartTree.TreeElement
import com.intellij.lang.ASTNode
import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import javax.swing.Icon

open class MixinTagged(node: ASTNode) : DeclareNode(node) {
    override fun getOriginalElement(): ValkyrieTaggedStatementNode {
        return this as ValkyrieTaggedStatementNode
    }
    override fun getNameIdentifier(): PsiElement = originalElement

    override fun getIcon(flags: Int): Icon = AllIcons.Nodes.Enum

    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }

    override fun getChildrenView(): Array<TreeElement> {
//        PsiTreeUtil.getChildrenOfTypeAsList(
//            this.taggedBlock,
//            NavigatablePsiElement::class.java
//        ).forEach {
//            if (it is ValkyrieTaggedItem) {
//                val kind = ValkyriePresentationItem(it.identifier.text, AllIcons.Nodes.Variable)
//                childrenView.add(ValkyrieViewElement(it, kind))
//            }
//        }
        return super.getChildrenView()
    }

}

