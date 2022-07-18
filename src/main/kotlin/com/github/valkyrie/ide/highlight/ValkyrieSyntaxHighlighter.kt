package com.github.valkyrie.ide.highlight


import com.github.valkyrie.language.psi.ValkyrieLexerAdapter
import com.github.valkyrie.language.psi.ValkyrieTypes.*
import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType
import com.github.valkyrie.ide.highlight.ValkyrieHighlightColor as Color

class ValkyrieSyntaxHighlighter : SyntaxHighlighterBase() {
    override fun getHighlightingLexer(): Lexer {
        return ValkyrieLexerAdapter()
    }

    override fun getTokenHighlights(tokenType: IElementType): Array<TextAttributesKey> {
        return pack(getTokenColor(tokenType)?.textAttributesKey)
    }

    private fun getTokenColor(tokenType: IElementType): Color? {
        return when (tokenType) {
            // Keywords
            IMPORT, KW_IMPORT, KW_EXTENSION, KW_NAMESPACE -> Color.KEYWORD
            MATCH, CATCH, EXTENDS, CASE -> Color.KEYWORD
            IF, ELSE, FOR, IN, WHILE -> Color.KEYWORD
            LET, DEFINE, CLASS, TRAIT, TAGGED, BITFLAG, FORALL, TYPE -> Color.KEYWORD
            // ANNOTATION -> JssColor.ANNOTATION
            //
            PARENTHESIS_L, PARENTHESIS_R -> Color.PARENTHESES
            BRACKET_L, BRACKET_R -> Color.BRACKETS
            BRACE_L, BRACE_R -> Color.BRACES
            COLON, BIND -> Color.SET
            // STAR -> Color.STAR
            COMMA -> Color.COMMA
            VERTICAL, LESS, GREATER, DOT3, DOT2, PLUS, MINUS, DOT_LESS, DOT_EQ -> Color.OPERATION_SIGN
            EQ, NE -> Color.OPERATION_SIGN
            NOT, BANG, AMP, QUESTION -> Color.OPERATION_SIGN
            // 原子类型
            INTEGER -> Color.INTEGER
            BYTE -> Color.INTEGER
            DECIMAL -> Color.DECIMAL
            STRING_CHAR -> Color.STRING
            STRING_START, STRING_END, STRING_CHAR, STRING_EMPTY -> Color.STRING
            SYMBOL_XID, SYMBOL_RAW -> Color.IDENTIFIER
            // 注释
            COMMENT_LINE -> Color.LINE_COMMENT
            COMMENT_BLOCK -> Color.BLOCK_COMMENT
            COMMENT_DOCUMENT -> Color.DOC_COMMENT
            // 错误
            TokenType.BAD_CHARACTER -> Color.BAD_CHARACTER
            else -> null
        }
    }
}
