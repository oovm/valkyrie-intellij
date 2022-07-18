package com.github.valkyrie.ide.codeStyle

import com.github.valkyrie.ValkyrieLanguage
import com.intellij.application.options.GenerationCodeStylePanel
import com.intellij.application.options.TabbedLanguageCodeStylePanel
import com.intellij.psi.codeStyle.CodeStyleSettings

class ValkyrieCodeStyleMainPanel(currentSettings: CodeStyleSettings?, settings: CodeStyleSettings) :
    TabbedLanguageCodeStylePanel(ValkyrieLanguage, currentSettings, settings) {
    override fun initTabs(settings: CodeStyleSettings) {
        addIndentOptionsTab(settings)
        addWrappingAndBracesTab(settings)
        addTab(GenerationCodeStylePanel(settings, ValkyrieLanguage))
    }
}
