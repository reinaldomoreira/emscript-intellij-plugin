package com.github.reinaldomoreira.emscriptintellijplugin.language

import com.github.reinaldomoreira.emscriptintellijplugin.language.psi.EMScriptTypes
import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.HighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType

class EMScriptSyntaxHighlighter : SyntaxHighlighterBase() {

    companion object {
        internal val SEPARATOR = createTextAttributesKey("EMS_SEPARATOR", DefaultLanguageHighlighterColors.OPERATION_SIGN)
        internal val KEY = createTextAttributesKey("EMS_KEY", DefaultLanguageHighlighterColors.KEYWORD)
        internal val VALUE = createTextAttributesKey("EMS_VALUE", DefaultLanguageHighlighterColors.STRING)
        internal val COMMENT = createTextAttributesKey("EMS_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT)
        internal val BAD_CHARACTER = createTextAttributesKey("EMS_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER)

        private val BAD_CHAR_KEYS = arrayOf(BAD_CHARACTER)
        private val SEPARATOR_KEYS = arrayOf(SEPARATOR)
        private val KEY_KEYS = arrayOf(KEY)
        private val VALUE_KEYS = arrayOf(VALUE)
        private val COMMENT_KEYS = arrayOf(COMMENT)
        private val EMPTY_KEYS = arrayOf<TextAttributesKey>()
    }


    override fun getHighlightingLexer(): Lexer {
        return EMScriptLexerAdapter()
    }

    override fun getTokenHighlights(tokenType: IElementType?): Array<TextAttributesKey> {
        return when (tokenType) {
            EMScriptTypes.SEPARATOR -> SEPARATOR_KEYS
            EMScriptTypes.KEY -> KEY_KEYS
            EMScriptTypes.VALUE -> VALUE_KEYS
            EMScriptTypes.COMMENT -> COMMENT_KEYS
            EMScriptTypes.BAD_CHARACTER -> BAD_CHAR_KEYS
            else -> EMPTY_KEYS
        }
    }
}