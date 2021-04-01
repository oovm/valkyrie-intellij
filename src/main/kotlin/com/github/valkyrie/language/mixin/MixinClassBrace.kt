package com.github.valkyrie.language.mixin

import com.github.valkyrie.ide.view.ValkyrieViewElement
import com.github.valkyrie.language.ast.DeclareNode
import com.github.valkyrie.language.psi.ValkyrieClassBraceItem
import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import javax.swing.Icon

abstract class MixinClassBrace(node: ASTNode) : DeclareNode(node),
    ValkyrieClassBraceItem {
    override val viewIcon: Icon = AllIcons.Nodes.Field;
    override fun addChildrenView(childrenView: MutableSet<ValkyrieViewElement>) {
//        val kind = ValkyriePresentationItem(this.navigationElement.text, AllIcons.Nodes.Variable)
//        this.childrenView.add(ValkyrieViewElement(this, kind))
    }

    override fun getNameIdentifier(): PsiElement {
        val index = this.classNumericKey;
        return when {
            index != null -> index.lastChild
            else -> this.modifierSymbols?.lastChild ?: this.originalElement
        }
    }

    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }
}

