package com.github.valkyrie

import com.intellij.lang.Language

private const val LanguageID = "Valkyrie"

object ValkyrieLanguage: Language(LanguageID) {
    override fun getDisplayName(): String {
        return super.getDisplayName()
    }
    override fun getMimeTypes(): Array<String> {
        return arrayOf("text/x-valkyrie")
    }
}