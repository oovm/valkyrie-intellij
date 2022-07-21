package com.github.valkyrie.language.lexer

enum class LexerContext(val id: Int) {
    Coding(0),
    TEXT(98),
    COMMENT(99)
    ;

    fun intoID() = this.id

    companion object {
        fun fromID(id: Int): LexerContext {
            val out = values().firstOrNull { it.id == id };
            return out!!
        }
    }
}