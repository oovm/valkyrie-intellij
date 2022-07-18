package com.github.valkyrie.language.lexer

enum class StackContext(val id: Int) {
    CODE(0),
    TEXT(1),
    COMMENT(9)
    ;

    fun intoID() = this.id

    companion object {
        fun fromID(id: Int): StackContext {
            val out = values().firstOrNull { it.id == id };
            return out!!
        }
    }
}