package com.github.reinaldomoreira.emscriptintellijplugin.language.psi

import com.github.reinaldomoreira.emscriptintellijplugin.language.EMScriptLanguage
import com.intellij.psi.tree.IElementType
import org.jetbrains.annotations.NonNls

class EMScriptElementType(debugName: @NonNls String) : IElementType(debugName, EMScriptLanguage.INSTANCE)