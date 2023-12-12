package com.github.reinaldomoreira.emscriptintellijplugin.language.psi.impl

import com.github.reinaldomoreira.emscriptintellijplugin.language.psi.EMScriptProperty
import com.github.reinaldomoreira.emscriptintellijplugin.language.psi.EMScriptTypes
import com.intellij.lang.ASTNode

class EMScriptPsiImplUtil {
    companion object {
        @JvmStatic
        fun getKey(element: EMScriptProperty): String? {
            val keyNode: ASTNode? = element.node.findChildByType(EMScriptTypes.KEY)
            return keyNode?.text?.replace("\\\\ ".toRegex(), " ")
        }

        @JvmStatic
        fun getValue(element: EMScriptProperty): String? {
            return element.node.findChildByType(EMScriptTypes.VALUE)?.text
        }
    }
}
