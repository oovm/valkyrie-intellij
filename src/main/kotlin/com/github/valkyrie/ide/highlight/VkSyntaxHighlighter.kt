package com.github.valkyrie.ide.highlight


import com.github.valkyrie.language.psi.ValkyrieLexerAdapter
import com.github.valkyrie.language.psi.ValkyrieTypes.*
import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType
import com.github.valkyrie.ide.highlight.VkHighlightColor as Color

class VkSyntaxHighlighter : SyntaxHighlighterBase() {
    override fun getHighlightingLexer(): Lexer {
        return ValkyrieLexerAdapter()
    }

    override fun getTokenHighlights(tokenType: IElementType): Array<TextAttributesKey> {
        return pack(getTokenColor(tokenType)?.textAttributesKey)
    }

    private fun getTokenColor(tokenType: IElementType): Color? {
        return when (tokenType) {
            // Keywords
            MATCH, CATCH -> Color.KEYWORD
            IF, ELSE, FOR, IN, WHILE -> Color.KEYWORD
            LET, DEF, CLASS, TRAIT -> Color.KEYWORD
            // ANNOTATION -> JssColor.ANNOTATION
            //
            PARENTHESIS_L, PARENTHESIS_R -> Color.PARENTHESES
            BRACKET_L, BRACKET_R -> Color.BRACKETS
            BRACE_L, BRACE_R -> Color.BRACES
            COLON, EQ -> Color.SET
            STAR -> Color.STAR
            COMMA -> Color.COMMA
            // 原子类型
            INTEGER -> Color.INTEGER
            DECIMAL -> Color.DECIMAL
            STRING_CHAR -> Color.STRING
            STRING_QUOTE, STRING_CHAR -> Color.STRING
            STRING_ESCAPE -> Color.STRING_ESCAPED
            SYMBOL -> Color.IDENTIFIER
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