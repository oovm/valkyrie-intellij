package com.github.valkyrie.ide.hint

import com.github.valkyrie.language.psi_node.*
import com.intellij.codeInsight.hints.VcsCodeVisionLanguageContext
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiElement
import java.awt.event.MouseEvent

@Suppress("UnstableApiUsage")
class ValkyrieInlayVSCProvider : VcsCodeVisionLanguageContext {
    /// 额外的点击事件
    /// 本身会打开 Git Blame
    override fun handleClick(mouseEvent: MouseEvent, editor: Editor, element: PsiElement) {

    }

    override fun isAccepted(element: PsiElement): Boolean = when (element) {
        //  is ValkyrieLetStatementNode,
        is ValkyrieTaggedStatementNode,
        is ValkyrieClassStatementNode,
        is ValkyrieTraitStatementNode,
        is ValkyrieExtendsStatementNode,
        -> true
        else -> false
    }
}

