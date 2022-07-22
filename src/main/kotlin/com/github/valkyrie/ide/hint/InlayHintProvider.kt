package com.github.valkyrie.ide.hint

import com.github.valkyrie.ValkyrieBundle
import com.intellij.codeInsight.hints.*
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import javax.swing.JComponent
import javax.swing.JTextField

@Suppress("UnstableApiUsage")
class InlayHintProvider : InlayHintsProvider<InlayHintProvider.Settings> {
    companion object {
        private val KEY: SettingsKey<Settings> = SettingsKey("v.type.hints")
    }

    data class Settings(
        var showForVariables: Boolean = true,
        var showForLambdas: Boolean = true,
        var showForIterators: Boolean = true,
        var showForPlaceholders: Boolean = true,
        var showObviousTypes: Boolean = false,
    )

    override val key: SettingsKey<Settings> get() = KEY
    override val name: String = ValkyrieBundle.message("view.PropertiesGrouper")
    override val group: InlayGroup = InlayGroup.TYPES_GROUP
    override fun createSettings(): Settings = Settings()
    /// 显示在
    /// Editor > Inlay Hints > Types
    override val previewText: String = """
        class Foo<T1, T2, T3> { x: T1, y: T2, z: T3 }
        def main() {
            let foo = Foo { x: 1, y: "abc", z: true };
        }
        """.trimIndent()
    /// 不知道干嘛的 显示在
    /// Editor > Inlay Hints > Types
    override fun createConfigurable(settings: Settings): ImmediateConfigurable {
        return object : ImmediateConfigurable {
            override fun createComponent(listener: ChangeListener): JComponent {
                return JTextField("TODO: createConfigurable")
            }
        }
    }
    override fun getCollectorFor(file: PsiFile, editor: Editor, settings: Settings, sink: InlayHintsSink): InlayHintsCollector? {
        return object : InlayHintsCollector {
            override fun collect(element: PsiElement, editor: Editor, sink: InlayHintsSink): Boolean {
                return true
            }
        }
    }
}

