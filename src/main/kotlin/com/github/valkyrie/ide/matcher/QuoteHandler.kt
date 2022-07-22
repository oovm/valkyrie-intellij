package com.github.valkyrie.ide.matcher

import com.intellij.codeInsight.editorActions.QuoteHandler
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.editor.highlighter.HighlighterIterator


class QuoteHandler: QuoteHandler {
    override fun isClosingQuote(iterator: HighlighterIterator?, offset: Int): Boolean {
        return true
    }

    override fun isOpeningQuote(iterator: HighlighterIterator?, offset: Int): Boolean {
        return true
    }

    override fun hasNonClosedLiteral(editor: Editor?, iterator: HighlighterIterator?, offset: Int): Boolean {
        return false
    }

    override fun isInsideLiteral(iterator: HighlighterIterator?): Boolean {
        return false
    }

}