package com.github.reinaldomoreira.emscriptintellijplugin.language.psi

import com.intellij.psi.tree.TokenSet

interface EMScriptTokenSets {
    companion object {
        val IDENTIFIERS = TokenSet.create(EMScriptTypes.KEY)
        val COMMENTS = TokenSet.create(EMScriptTypes.COMMENT)
    }
}