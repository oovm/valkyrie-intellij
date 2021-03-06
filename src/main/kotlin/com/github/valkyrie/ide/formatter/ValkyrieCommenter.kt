package com.github.valkyrie.ide.formatter

import com.intellij.lang.Commenter

class ValkyrieCommenter : Commenter {
    override fun getLineCommentPrefix(): String = "//"

    override fun getBlockCommentPrefix(): String = "//+"

    override fun getBlockCommentSuffix(): String = "//-"

    override fun getCommentedBlockCommentPrefix(): String? = null

    override fun getCommentedBlockCommentSuffix(): String? = null
}
