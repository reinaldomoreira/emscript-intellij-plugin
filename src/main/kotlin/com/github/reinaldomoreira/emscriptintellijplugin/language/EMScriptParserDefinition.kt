package com.github.reinaldomoreira.emscriptintellijplugin.language

import com.github.reinaldomoreira.emscriptintellijplugin.language.psi.EMScriptFile
import com.github.reinaldomoreira.emscriptintellijplugin.language.psi.EMScriptParser
import com.github.reinaldomoreira.emscriptintellijplugin.language.psi.EMScriptTokenSets
import com.github.reinaldomoreira.emscriptintellijplugin.language.psi.EMScriptTypes
import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet

class EMScriptParserDefinition : ParserDefinition {

    companion object {
        val FILE = IFileElementType(EMScriptLanguage.INSTANCE)
    }

    override fun createLexer(p0: Project?): Lexer {
        return EMScriptLexerAdapter()
    }

    override fun createParser(p0: Project?): PsiParser {
        return EMScriptParser()
    }

    override fun getFileNodeType(): IFileElementType {
        return FILE
    }

    override fun getCommentTokens(): TokenSet {
        return EMScriptTokenSets.COMMENTS
    }

    override fun getStringLiteralElements(): TokenSet {
        return TokenSet.EMPTY
    }

    override fun createElement(node: ASTNode?): PsiElement {
        return EMScriptTypes.Factory.createElement(node)
    }

    override fun createFile(viewProvider: FileViewProvider): PsiFile {
        return EMScriptFile(viewProvider)
    }
}