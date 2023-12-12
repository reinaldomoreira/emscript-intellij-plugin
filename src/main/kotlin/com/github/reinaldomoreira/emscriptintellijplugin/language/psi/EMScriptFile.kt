package com.github.reinaldomoreira.emscriptintellijplugin.language.psi

import com.github.reinaldomoreira.emscriptintellijplugin.language.EMScriptFileType
import com.github.reinaldomoreira.emscriptintellijplugin.language.EMScriptLanguage
import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider

class EMScriptFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, EMScriptLanguage.INSTANCE) {
    override fun getFileType(): FileType {
        return EMScriptFileType.INSTANCE
    }

    override fun toString(): String {
        return "EMScript"
    }
}