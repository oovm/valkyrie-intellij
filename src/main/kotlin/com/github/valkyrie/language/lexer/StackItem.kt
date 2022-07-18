package com.github.valkyrie.language.lexer

import com.intellij.psi.tree.IElementType

@Suppress("MemberVisibilityCanBePrivate")
class StackItem {
    var token: IElementType
    val startOffset: Int
    val endOffset: Int
    var context: StackContext
    var paired: Boolean? = null

    constructor(token: IElementType, startOffset: Int, endOffset: Int, context: StackContext) {
        this.token = token
        this.startOffset = startOffset
        this.endOffset = endOffset
        this.context = context
    }

    constructor(token: IElementType, match: MatchGroup, context: StackContext) {
        this.token = token
        this.startOffset = match.range.first
        this.endOffset = match.range.last + 1
        this.context = context
    }

    fun getState(): Int {
        return context.intoID()
    }

    override fun toString(): String {
        return "${token}[$startOffset-$endOffset]@${context}"
    }

    fun setPaired() {
        this.paired = true
    }

    fun setPlainText() {
//        this.token = NoteTypes.PLAIN_TEXT;
//        this.paired = null;
    }

    fun tokenIs(vararg token: IElementType): Boolean {
        return token.firstOrNull { it == this.token } != null
    }

    fun IElementType.isHardLeftMark(): Boolean? = when (this) {
        else -> null
    }

    companion object {

    }
}