package com.github.valkyrie.language.mixin

import com.github.valkyrie.language.ast.DeclareNode
import com.github.valkyrie.language.ast.FunctionKind
import com.github.valkyrie.language.psi_node.ValkyrieDefineItemNode
import com.github.valkyrie.language.psi_node.ValkyrieDefineStatementNode
import com.github.valkyrie.language.psi_node.ValkyrieIdentifierNode
import com.github.valkyrie.language.psi_node.ValkyrieNamespaceFreeNode
import com.intellij.icons.AllIcons.Nodes.Function
import com.intellij.icons.AllIcons.Nodes.Method
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import javax.swing.Icon

open class MixinDefine(node: ASTNode) : DeclareNode(node) {

    override fun getOriginalElement(): ValkyrieDefineStatementNode {
        return this as ValkyrieDefineStatementNode
    }

    override fun getNameIdentifier(): ValkyrieIdentifierNode {
        return originalElement.namespaceFree.identifierList.last() as ValkyrieIdentifierNode
    }

    override fun getIcon(flags: Int): Icon = when {
        originalElement.isMethod() -> Method
        else -> Function
    }

    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }

    val kind: FunctionKind
        get() {
            val namespace = originalElement.namespaceFree as ValkyrieNamespaceFreeNode;
            val lastDot = namespace.delimiterList().lastOrNull();
            val firstArg = originalElement.defineTuple.defineItemList.firstOrNull()
            return when {
                lastDot?.text == "::" -> FunctionKind.STATIC_METHOD
                lastDot?.text == "." -> FunctionKind.METHOD
                firstArg == null -> FunctionKind.FREE_FUNCTION
                else -> FunctionKind.FREE_FUNCTION
            }
        }

    fun isMethod(): Boolean = kind.isMethod
    fun isStatic(): Boolean = kind.isStatic

    fun hasMutableArgument(): Boolean {
        return originalElement.defineTuple.defineItemList.any {
            (it as ValkyrieDefineItemNode).hasMutable()
        }
    }
}

