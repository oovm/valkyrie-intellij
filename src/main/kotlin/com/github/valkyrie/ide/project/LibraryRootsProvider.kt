package com.github.valkyrie.ide.project

import com.intellij.openapi.project.Project
import com.intellij.openapi.roots.AdditionalLibraryRootsProvider
import com.intellij.openapi.roots.SyntheticLibrary
import com.intellij.openapi.vfs.VirtualFile

class LibraryRootsProvider : AdditionalLibraryRootsProvider() {
    override fun getAdditionalProjectLibraries(project: Project): MutableCollection<SyntheticLibrary> {
        return super.getAdditionalProjectLibraries(project)
    }

    override fun getRootsToWatch(project: Project): MutableCollection<VirtualFile> {
        return super.getRootsToWatch(project)
    }
}


