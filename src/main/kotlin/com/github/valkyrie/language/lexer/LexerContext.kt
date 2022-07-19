package com.github.valkyrie.language.lexer

enum class LexerContext(val id: Int) {
    CODE(0),
    Let(1),
    Define(2),
    Type(11),

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