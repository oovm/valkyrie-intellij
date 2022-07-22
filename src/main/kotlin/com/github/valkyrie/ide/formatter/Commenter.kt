package com.github.valkyrie.ide.formatter

import com.intellij.lang.Commenter

class Commenter : Commenter {
    override fun getLineCommentPrefix(): String = "#"

    override fun getBlockCommentPrefix(): String = "###"

    override fun getBlockCommentSuffix(): String = "###"
    override fun getCommentedBlockCommentPrefix(): String? {
        return null
    }
    override fun getCommentedBlockCommentSuffix(): String? {
        return null
    }
    override fun getLineCommentPrefixes(): MutableList<String> {
        return super.getLineCommentPrefixes()
    }
}
