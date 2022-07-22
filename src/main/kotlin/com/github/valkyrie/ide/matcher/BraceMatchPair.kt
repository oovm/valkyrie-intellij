package com.github.valkyrie.ide.matcher

import com.github.valkyrie.language.lexer.ValkyrieParserDefinition
import com.github.valkyrie.language.psi.ValkyrieTypes.*
import com.intellij.lang.BracePair
import com.intellij.lang.PairedBraceMatcher
import com.intellij.psi.PsiFile
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.TokenSet

class BraceMatchPair : PairedBraceMatcher {
    override fun getPairs(): Array<BracePair> = arrayOf(
        BracePair(BRACE_L, BRACE_R, true),
        BracePair(BRACKET_L, BRACKET_R, true),
        BracePair(PARENTHESIS_L, PARENTHESIS_R, true),
        BracePair(OP_LT, OP_GT, true),
        BracePair(STRING_START, STRING_END, true),
    )

    override fun isPairedBracesAllowedBeforeType(lbraceType: IElementType, next: IElementType?): Boolean {
        return next in InsertPairBraceBefore
    }

    override fun getCodeConstructStart(file: PsiFile?, openingBraceOffset: Int): Int = openingBraceOffset

    companion object {
        private val InsertPairBraceBefore = TokenSet.orSet(
            ValkyrieParserDefinition.commentTokens,
            TokenSet.create(
                TokenType.WHITE_SPACE,
                COMMA,
                PARENTHESIS_R,
                BRACKET_R,
                BRACE_R,
            )
        )
    }
}

