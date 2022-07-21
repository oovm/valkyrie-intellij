package com.github.valkyrie.language.lexer


import com.github.valkyrie.ValkyrieLanguage
import com.github.valkyrie.ide.file.ValkyrieFileNode
import com.github.valkyrie.language.parser.ValkyrieParser
import com.github.valkyrie.language.psi.ValkyrieTypes

import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.ParserDefinition.SpaceRequirements
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet


object ValkyrieParserDefinition : ParserDefinition {
    override fun createLexer(project: Project): Lexer = ValkyrieLexerAdapter()

    override fun createParser(project: Project): PsiParser = ValkyrieParser()

    override fun getFileNodeType(): IFileElementType = IFileElementType(ValkyrieLanguage)

    override fun getWhitespaceTokens(): TokenSet {
        return super.getWhitespaceTokens()
    }

    override fun getCommentTokens(): TokenSet = TokenSet.create(ValkyrieTypes.COMMENT)

    override fun getStringLiteralElements(): TokenSet {
        return TokenSet.create(ValkyrieTypes.STRING_START, ValkyrieTypes.STRING_TEXT, ValkyrieTypes.STRING_END)
    }

    override fun createElement(node: ASTNode): PsiElement = ValkyrieTypes.Factory.createElement(node)

    override fun createFile(viewProvider: FileViewProvider): PsiFile = ValkyrieFileNode(viewProvider)

    override fun spaceExistenceTypeBetweenTokens(left: ASTNode, right: ASTNode): SpaceRequirements {
        return SpaceRequirements.MAY
    }
}
