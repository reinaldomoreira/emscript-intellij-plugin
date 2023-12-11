package com.github.reinaldomoreira.emscriptintellijplugin.language

import com.intellij.openapi.fileTypes.LanguageFileType
import javax.annotation.Nonnull
import javax.swing.Icon

@Suppress("CompanionObjectInExtension")
class EMScriptFileType : LanguageFileType(EMScriptLanguage.INSTANCE) {

    companion object {
        val INSTANCE = EMScriptFileType()
    }
    @Nonnull
    override fun getName(): String {
        return "EMScript File"
    }

    @Nonnull
    override fun getDescription(): String {
        return "EMScript language file"
    }

    @Nonnull
    override fun getDefaultExtension(): String {
        return "ems"
    }

    @Nonnull
    override fun getIcon(): Icon {
        return EMScriptIcon.FILE
    }
}

