package com.github.valkyrie.ide.actions

import com.github.valkyrie.ide.file.ValkyrieIconProvider.Companion.FILE
import com.intellij.ide.actions.CreateFileFromTemplateAction
import com.intellij.ide.actions.CreateFileFromTemplateDialog.Builder
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiDirectory

class ValkyrieCreateFile :
    CreateFileFromTemplateAction(name, description, FILE) {
    companion object {
        private val name = com.github.valkyrie.ValkyrieBundle.message("action.create_file")
        private val description = com.github.valkyrie.ValkyrieBundle.message("action.create_file.description")
        // See [resources/colors/fileTemplate]
        private const val templatePath = "Valkyrie File";
    }

    override fun buildDialog(project: Project, directory: PsiDirectory, builder: Builder) {
        builder.setTitle(name).addKind("Empty file", FILE, templatePath)
    }

    override fun getActionName(directory: PsiDirectory, newName: String, templateName: String): String = name
}
