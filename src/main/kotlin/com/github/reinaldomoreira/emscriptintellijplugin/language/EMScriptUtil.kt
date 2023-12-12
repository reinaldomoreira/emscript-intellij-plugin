package com.github.reinaldomoreira.emscriptintellijplugin.language

import com.github.reinaldomoreira.emscriptintellijplugin.language.psi.EMScriptFile
import com.github.reinaldomoreira.emscriptintellijplugin.language.psi.EMScriptProperty
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.text.StringUtil
import com.intellij.psi.PsiComment
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiManager
import com.intellij.psi.PsiWhiteSpace
import com.intellij.psi.search.FileTypeIndex
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.util.PsiTreeUtil
import java.util.*


class EMScriptUtil {

    /**
     * Searches the entire project for EMScript language files with instances of the EMScript property with the given key.
     *
     * @param project current project
     * @param key     to check
     * @return matching properties
     */
    fun findProperties(project: Project, key: String): List<EMScriptProperty> {
        val result: MutableList<EMScriptProperty> = ArrayList<EMScriptProperty>()
        val virtualFiles =
            FileTypeIndex.getFiles(EMScriptFileType.INSTANCE, GlobalSearchScope.allScope(project))
        for (virtualFile in virtualFiles) {
            val emScriptFile: EMScriptFile? = PsiManager.getInstance(project).findFile(virtualFile) as EMScriptFile?
            if (emScriptFile != null) {
                val properties: Array<out EMScriptProperty>? = PsiTreeUtil.getChildrenOfType(emScriptFile, EMScriptProperty::class.java)
                if (properties != null) {
                    for (property in properties) {
                        if (key == property.getKey()) {
                            result.add(property)
                        }
                    }
                }
            }
        }
        return result
    }

    fun findProperties(project: Project): List<EMScriptProperty> {
        val result: MutableList<EMScriptProperty> = ArrayList<EMScriptProperty>()
        val virtualFiles =
            FileTypeIndex.getFiles(EMScriptFileType.INSTANCE, GlobalSearchScope.allScope(project))
        for (virtualFile in virtualFiles) {
            val emsFile: EMScriptFile? = PsiManager.getInstance(project).findFile(virtualFile) as EMScriptFile?
            if (emsFile != null) {
                val properties: Array<EMScriptProperty>? = PsiTreeUtil.getChildrenOfType(emsFile, EMScriptProperty::class.java)
                if (properties != null) {
                    result += properties
                }
            }
        }
        return result
    }

    /**
     * Attempts to collect any comment elements above the EMScript key/value pair.
     */
    fun findDocumentationComment(property: EMScriptProperty): String {
        val result: MutableList<String> = LinkedList()
        var element: PsiElement = property.prevSibling
        while (element is PsiComment || element is PsiWhiteSpace) {
            if (element is PsiComment) {
                val commentText = element.getText().replaceFirst("[!# ]+".toRegex(), "")
                result.add(commentText)
            }
            element = element.prevSibling
        }
        return StringUtil.join(result.asReversed(), "\n ")
    }
}