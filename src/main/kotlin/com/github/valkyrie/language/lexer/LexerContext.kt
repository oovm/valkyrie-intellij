package com.github.valkyrie.language.lexer

enum class LexerContext(val id: Int) {
    //
    TopCoding(0),
    // Common coding scenarios where keywords are not detected
    Coding(1),
    Let(1),
    CatchModifier(2),
    // DefineSymbol(2),
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