package com.github.valkyrie.language.lexer


import com.intellij.lexer.LexerBase
import com.intellij.psi.tree.IElementType

class ValkyrieLexerAdapter : LexerBase() {
    private var buffer: CharSequence = ""
    private var startOffset: Int = 0
    private var endOffset: Int = 0
    private var stack: Array<StackItem> = arrayOf()
    private var index: Int = 0
    override fun start(buffer: CharSequence, startOffset: Int, endOffset: Int, initialState: Int) {
        if (this.buffer == buffer && this.startOffset == startOffset && this.endOffset == endOffset) {
            this.index = 0
        }
        else {
            this.buffer = buffer
            this.startOffset = startOffset
            this.endOffset = endOffset
            val context = LexerContext.fromID(initialState);
            this.stack = TokenInterpreter(buffer, startOffset, endOffset).interpreter()
            this.index = 0
        }
    }

    override fun getState(): Int = stack.getOrNull(index)?.getState() ?: 0
    override fun getTokenType(): IElementType? = stack.getOrNull(index)?.token
    override fun getTokenStart(): Int = stack.getOrNull(index)?.startOffset ?: startOffset
    override fun getTokenEnd(): Int = stack.getOrNull(index)?.endOffset ?: endOffset
    override fun advance() {
        index++
    }

    override fun getBufferSequence(): CharSequence = buffer
    override fun getBufferEnd(): Int = endOffset

    private fun eraseImbalance() {
        for (item in stack) {
            if (item.paired == false) {
                item.setPlainText()
            }
        }
    }
}


