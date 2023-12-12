package com.github.reinaldomoreira.emscriptintellijplugin.language.psi

import com.github.reinaldomoreira.emscriptintellijplugin.language.EMScriptLanguage
import com.intellij.lang.Language
import com.intellij.psi.tree.IElementType
import org.jetbrains.annotations.NonNls

class EMScriptTokenType(debugName: @NonNls String) : IElementType(debugName, EMScriptLanguage.INSTANCE) {

    override fun toString(): String {
        return "EMScriptTokenType." + super.toString()
    }
}