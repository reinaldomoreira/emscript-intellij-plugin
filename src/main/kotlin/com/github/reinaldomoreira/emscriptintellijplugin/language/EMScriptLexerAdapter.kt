package com.github.reinaldomoreira.emscriptintellijplugin.language

import com.intellij.lexer.FlexAdapter

class EMScriptLexerAdapter: FlexAdapter(EMScriptLexer(null)) {
}