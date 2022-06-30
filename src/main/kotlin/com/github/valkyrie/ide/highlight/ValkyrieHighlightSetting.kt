package com.github.valkyrie.ide.highlight

import com.github.valkyrie.ValkyrieBundle
import com.github.valkyrie.ide.file.ValkyrieIconProvider

import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage

class ValkyrieHighlightSetting : ColorSettingsPage {
    private val annotatorTags = ValkyrieHighlightColor
        .values()
        .associateBy({ it.name }, { it.textAttributesKey })

    override fun getAttributeDescriptors() = ValkyrieHighlightColor
        .values()
        .map { it.attributesDescriptor }
        .toTypedArray()

    override fun getColorDescriptors(): Array<ColorDescriptor> = ColorDescriptor.EMPTY_ARRAY

    override fun getDisplayName() = ValkyrieBundle.message("filetype.name")

    override fun getIcon() = ValkyrieIconProvider.IconSVG

    override fun getHighlighter() = ValkyrieSyntaxHighlighter()

    override fun getAdditionalHighlightingTagToDescriptorMap() = annotatorTags

    override fun getDemoText() =
        """//? [Valkyrie]
crate <KEYWORD>depot</KEYWORD>::module;

using std.module;

trait <SYM_TRAIT>TraitName</SYM_TRAIT> {
    def trait_method(<SYM_ARG_SELF>self</SYM_ARG_SELF>) -> Self;
    def trait_method_mut(<KEYWORD>mut</KEYWORD> <SYM_ARG_SELF_MUT>self</SYM_ARG_SELF_MUT>) -> Self;
    def trait_static(<SYM_ARG>arg</SYM_ARG> = 0) -> Self;
    def trait_static_mut(<KEYWORD>mut</KEYWORD> <SYM_ARG_MUT>arg</SYM_ARG_MUT>) -> Self;
}

class <SYM_CLASS>ClassName</SYM_CLASS>: <SYM_TRAIT>TraitName</SYM_TRAIT> {
    string: <SYM_CLASS>String</SYM_CLASS> = <STRING>"default value"</STRING>
}

//?
class <SYM_CLASS>ClassTuple</SYM_CLASS>(<SYM_CLASS>Integer</SYM_CLASS> = 0, <SYM_CLASS>Integer</SYM_CLASS> = 0)

//?
class <SYM_CLASS>ClassBlock</SYM_CLASS> {
    0: <SYM_CLASS>Integer</SYM_CLASS> = 0,
    1: <SYM_CLASS>Integer</SYM_CLASS> = 0,
}

tagged <SYM_CLASS>TaggedName</SYM_CLASS> {
    <SYM_VARIANT>VariantName</SYM_VARIANT>()
}

bitset <SYM_CLASS>BitsetName</SYM_CLASS>: <KEYWORD>u8</KEYWORD> {
   <SYM_FIELD>BIT_FIELD</SYM_FIELD> = 0b0000_0001
}
"""


}
