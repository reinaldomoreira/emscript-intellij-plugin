package com.github.reinaldomoreira.emscriptintellijplugin.language

import com.intellij.lang.Language
import org.jetbrains.annotations.NonNls

class EMScriptLanguage : Language("EMScript") {
    companion object {
        val INSTANCE = EMScriptLanguage()
    }
}