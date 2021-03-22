package com.github.valkyrie.ide.view


import com.github.valkyrie.ide.file.ValkyrieFile
import com.intellij.ide.projectView.SelectableTreeStructureProvider
import com.intellij.ide.projectView.ViewSettings
import com.intellij.ide.projectView.impl.nodes.ExternalLibrariesNode
import com.intellij.ide.projectView.impl.nodes.PsiDirectoryNode
import com.intellij.ide.projectView.impl.nodes.PsiFileNode
import com.intellij.ide.util.treeView.AbstractTreeNode
import com.intellij.openapi.project.DumbAware
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiWhiteSpace
import com.intellij.psi.impl.source.tree.LeafPsiElement
import com.intellij.psi.impl.source.tree.PsiWhiteSpaceImpl


class VStructureProvider : SelectableTreeStructureProvider, DumbAware {
    override fun modify(
        parent: AbstractTreeNode<*>,
        children: MutableCollection<AbstractTreeNode<*>>,
        settings: ViewSettings?,
    ): List<AbstractTreeNode<out Any>> = children.map {
        when {
            it is PsiFileNode && it.value is ValkyrieFile -> CustomFileNode(it, settings)
            it is PsiFileNode -> it
            it is PsiDirectoryNode -> it
            it is ExternalLibrariesNode -> it
            else -> it
        }
    }

    override fun getTopLevelElement(element: PsiElement?): PsiElement? = when (element) {
        is PsiWhiteSpaceImpl, is PsiWhiteSpace, is LeafPsiElement -> {
            null
        }
        is ValkyrieFile -> {
            null
        }
        else -> TODO("Not yet implemented")
    }


    /// 自选 ValkyrieFile 的排序方式
    private class CustomFileNode(original: PsiFileNode, viewSettings: ViewSettings?) :
        PsiFileNode(original.project, original.value, viewSettings) {
        override fun getSortKey(): Int = when {
//            value.name == RsConstants.MOD_RS_FILE -> -2
//            (value as? RsFile)?.isCrateRoot == true -> -1
            else -> 0
        }
    }
}

