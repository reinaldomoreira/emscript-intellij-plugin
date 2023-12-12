package com.github.reinaldomoreira.emscriptintellijplugin.language.psi

import com.intellij.psi.tree.TokenSet

interface EMScriptTokenSets {
    companion object {
        @JvmStatic val IDENTIFIERS = TokenSet.create(EMScriptTypes.KEY)
        @JvmStatic val COMMENTS = TokenSet.create(EMScriptTypes.COMMENT)
    }
}