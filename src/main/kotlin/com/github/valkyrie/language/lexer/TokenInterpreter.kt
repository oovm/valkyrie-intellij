package com.github.valkyrie.language.lexer

import com.intellij.psi.TokenType
import notedge.idea.language.psi.*

class TokenInterpreter(val buffer: CharSequence, var startOffset: Int, val endOffset: Int, var context: StackContext) {
    companion object {
        val EOL = "\\R".toRegex()
        val ROL = "[^\\r\\n]+".toRegex()
        val WS_ROL = "([^\\S\\r\\n]*)([^\\r\\n]*)".toRegex()
        val WS = "[^\\S\\r\\n]+".toRegex()
        val NL = "\\r\\n|\\r|\\n".toRegex()
        val HEADER_HASH = "[＃#]+".toRegex()
        val ASTERISK = "[*]+".toRegex()
        val TILDE = "[_＿]+".toRegex()
        val STRING_1 = "(['｀])((?:[^\\\\`｀]|\\\\.)*)([`｀])".toRegex()
        val STRING_2 = "([\"｀])(( ?: [^\\\\`｀]|\\\\.)*)([`｀])".toRegex()
        val CODE_1 = "([`｀])((?:[^\\\\`｀]|\\\\.)*)(\\1)".toRegex()
        val CODE_2 = "([`｀]{2})((?:[^\\\\]|\\\\.)*?)(\\1)".toRegex()
        val CODE_3 = "[`｀]{3,}".toRegex()
        val MATH_1 = "([$＄])((?:[^\\\\$]|\\\\.)*)(\\1)".toRegex()
        val MATH_2 = "([$＄]{2})((?:[^\\\\]|\\\\.)*?)(\\1)".toRegex()

        val ESCAPE = "[\\\\＼]".toRegex()
        val ESCAPE_ANY = "\\\\.|＼．".toRegex()
        val SYMBOL = "[\\p{L}\\p{N}][\\p{L}_]*".toRegex()
        val DOT = "[.．]".toRegex()
        val COLON = "[:：]".toRegex()

        val PARENTHESIS_L = "[(（]".toRegex()
        val PARENTHESIS_R = "[)）]".toRegex()
        val BRACKET_L = "[\\[［]".toRegex()
        val BRACKET_R = "[]］]".toRegex()
        val BRACE_L = "[{｛]".toRegex()
        val BRACE_R = "[}｝]".toRegex()
        val DOUBLE_QUOTE = "[\"＂]".toRegex()
        val SINGLE_QUOTE = "['＇]".toRegex()
        val ANGLE_SL = "</|＜／".toRegex()
        val ANGLE_L = "[<＜]".toRegex()
        val ANGLE_R = "[>＞]".toRegex()
        val ANGLE_SR = "/>|／＞".toRegex()
    }

    var stack: MutableList<StackItem> = mutableListOf()

    fun interpreter(): Array<StackItem> {
        while (startOffset < endOffset) {
            if (matchesWhitespace()) continue
            if (matchesNewline()) continue
            when (context) {
                StackContext.TEXT -> {
                    // header
                    if (matchesHeadHash()) continue
                    // text
                    if (matchesEscape()) continue
                    if (matchesSymbol()) continue
                    if (matchTextDot()) continue
                    if (matchParenthesisL()) continue
                    if (matchAngleSL()) continue
                    if (matchAngleL()) continue
//                    if (matchBraceL()) continue
                    if (matchTextColon()) continue
                    // code
                    if (matchesCodeN()) continue
                    // style
                    if (matchesAsterisk()) continue
                    if (matchesTilde()) continue
                    if (finalCatchText()) continue
                }
                StackContext.CODE -> {
                    if (matchesSymbol()) continue
                    if (matchesCodeDelimiters()) continue
                    if (matchParenthesisL()) continue
                    if (matchParenthesisR()) continue
                    if (matchAngleL()) continue
                    if (matchAngleR()) continue
                    if (matchAngleSL()) continue
                    if (matchAngleSR()) continue
                }
                StackContext.STRING -> {}
            }
            break
        }
        checkRest()
        return stack.toTypedArray()
    }

    private fun matchesWhitespace(): Boolean {
        val r = WS.matchAt(buffer, startOffset) ?: return false
        when (context) {
            StackContext.TEXT -> {
                when {
                    lastIs(NoteTypes.BREAK_PART) -> {
                        stack.add(StackItem(NoteTypes.BREAK_PART, r, context))
                    }
                    else -> {
                        stack.add(StackItem(TokenType.WHITE_SPACE, r, context))
                    }
                }
            }
            StackContext.CODE -> stack.add(StackItem(TokenType.WHITE_SPACE, r, context))
            StackContext.STRING -> stack.add(StackItem(NoteTypes.STRING_TEXT, r, context))
        }
        return addOffset(r)
    }

    private fun matchesNewline(): Boolean {
        val r = NL.matchAt(buffer, startOffset) ?: return false
        when (context) {
            StackContext.TEXT -> when {
                shouldBreakParagraph() -> {
                    stack.add(StackItem(NoteTypes.BREAK_PART, r, context))
                }
                else -> {
                    stack.add(StackItem(NEW_LINE, r, context))
                }
            }
            StackContext.CODE -> stack.add(StackItem(NEW_LINE, r, context))
            StackContext.STRING -> stack.add(StackItem(NoteTypes.STRING_TEXT, r, context))
        }
        return addOffset(r)
    }

    private fun matchesHeadHash(): Boolean {
        val r = HEADER_HASH.matchAt(buffer, startOffset) ?: return false
        stack.add(StackItem(NoteTypes.HEADER_HASH, r, context))
        return addOffset(r)
    }

    private fun matchesEscape(): Boolean {
        assert(context == StackContext.TEXT)
        val r = ESCAPE.matchAt(buffer, startOffset) ?: return false
        stack.add(StackItem(NoteTypes.ESCAPE, r, context))
        return addOffset(r)
    }

    private fun matchesCodeDelimiters(): Boolean {
        assert(context == StackContext.CODE)
        val delimiters = "[:：.．,，=＝]".toRegex()
        val r = delimiters.matchAt(buffer, startOffset) ?: return false
        when (r.value) {
            ".", "．" -> stack.add(StackItem(NoteTypes.DOT, r, context))
            ",", "，" -> stack.add(StackItem(NoteTypes.COMMA, r, context))
            ":", "：" -> stack.add(StackItem(NoteTypes.COLON, r, context))
            "=", "＝" -> stack.add(StackItem(NoteTypes.EQ, r, context))
            else -> TODO("unreachable ${r.value}")
        }
        return addOffset(r)
    }

    private fun matchesSymbol(): Boolean {
        val r = SYMBOL.matchAt(buffer, startOffset) ?: return false
        when {
            context == StackContext.CODE -> {
                stack.add(StackItem(NoteTypes.SYMBOL, r, context))
            }
            lastIs(NoteTypes.ESCAPE, NoteTypes.DOT) -> {
                stack.add(StackItem(NoteTypes.SYMBOL, r, context))
            }
            else -> {
                stack.add(StackItem(NoteTypes.PLAIN_TEXT, r, context))
            }
        }
        return addOffset(r)
    }

    private fun matchTextDot(): Boolean {
        assert(context == StackContext.TEXT)
        val r = DOT.matchAt(buffer, startOffset) ?: return false
        when {
            lastIs(NoteTypes.SYMBOL) -> {
                stack.add(StackItem(NoteTypes.DOT, r, context))
            }
            else -> {
                stack.add(StackItem(NoteTypes.PLAIN_TEXT, r, context))
            }
        }
        return addOffset(r)
    }


    private fun matchTextColon(): Boolean {
        assert(context == StackContext.TEXT)
        val r = COLON.matchAt(buffer, startOffset) ?: return false
        when {
            lastNonWsIs(NoteTypes.PARENTHESIS_R, NoteTypes.SYMBOL) -> {
                stack.add(StackItem(NoteTypes.COLON, r, context))
                addOffset(r)
                appendWSROL(NoteTypes.STRING_TEXT)
            }
            else -> {
                stack.add(StackItem(NoteTypes.PLAIN_TEXT, r, context))
                addOffset(r)
            }
        }
        return true
    }

    private fun matchParenthesisL(): Boolean {
        val r = PARENTHESIS_L.matchAt(buffer, startOffset) ?: return false
        if (lastIs(NoteTypes.SYMBOL)) {
            context = StackContext.CODE
            stack.add(StackItem(NoteTypes.PARENTHESIS_L, r, context))
        }
        else {
            stack.add(StackItem(NoteTypes.PLAIN_TEXT, r, context))
        }
        return addOffset(r)
    }

    private fun matchParenthesisR(): Boolean {
        assert(context == StackContext.CODE)
        val r = PARENTHESIS_R.matchAt(buffer, startOffset) ?: return false
        stack.add(StackItem(NoteTypes.PARENTHESIS_R, r, context))
        context = StackContext.TEXT
        return addOffset(r)
    }

    private fun matchBraceL(): Boolean {
        val r = BRACE_L.matchAt(buffer, startOffset) ?: return false
        if (lastIs(NoteTypes.PARENTHESIS_R, NoteTypes.SYMBOL)) {
            context = StackContext.CODE
            stack.add(StackItem(NoteTypes.BRACE_L, r, context))
        }
        else {
            stack.add(StackItem(NoteTypes.PLAIN_TEXT, r, context))
        }
        return addOffset(r)
    }

    private fun matchBraceR(): Boolean {
        assert(context == StackContext.CODE)
        val r = BRACE_R.matchAt(buffer, startOffset) ?: return false
        stack.add(StackItem(NoteTypes.BRACE_R, r, context))
        context = StackContext.TEXT
        return addOffset(r)
    }

    private fun matchAngleL(): Boolean {
        val r = ANGLE_L.matchAt(buffer, startOffset) ?: return false
        context = StackContext.CODE
        stack.add(StackItem(NoteTypes.ANGLE_L, r, context))
        return addOffset(r)
    }

    private fun matchAngleR(): Boolean {
        assert(context == StackContext.CODE)
        val r = ANGLE_R.matchAt(buffer, startOffset) ?: return false
        stack.add(StackItem(NoteTypes.ANGLE_R, r, context))
        context = StackContext.TEXT
        return addOffset(r)
    }

    private fun matchAngleSL(): Boolean {
        val r = ANGLE_SL.matchAt(buffer, startOffset) ?: return false
        context = StackContext.CODE
        stack.add(StackItem(NoteTypes.ANGLE_SL, r, context))
        return addOffset(r)
    }

    private fun matchAngleSR(): Boolean {
        assert(context == StackContext.CODE)
        val r = ANGLE_SR.matchAt(buffer, startOffset) ?: return false
        stack.add(StackItem(NoteTypes.ANGLE_SR, r, context))
        context = StackContext.TEXT
        return addOffset(r)
    }

    private fun matchesCodeN(): Boolean {
        val code1 = "([`｀])((?:[^\\\\`｀]|\\\\.)*)(\\1)".toRegex()
        val code3 = "([`｀]{3,})([^｀]*?)(\\1)".toRegex()
        var r = code3.matchAt(buffer, startOffset)
        if (r == null) {
            r = code1.matchAt(buffer, startOffset)
        }
        if (r == null) return false
        addCodeGroup(r)
        return addOffset(r)
    }

    private fun matchesAsterisk(): Boolean {
        assert(context == StackContext.TEXT)
        val r = ASTERISK.matchAt(buffer, startOffset) ?: return false
        when (r.value.length) {
            1 -> matchesItalic(r)
            2 -> matchesBold(r)
            3 -> matchesStrong(r)
            else -> stack.add(StackItem(NoteTypes.PLAIN_TEXT, r, context))
        }
        return addOffset(r)
    }

    private fun matchesItalic(r: MatchResult) {
        for (item in stack.asReversed()) {
            when (item.token) {
                NoteTypes.BREAK_PART,
                NoteTypes.ITALIC_R -> {
                    stack.add(StackItem(NoteTypes.ITALIC_L, r, context, false))
                    return
                }
                NoteTypes.ITALIC_L -> {
                    item.setPaired()
                    stack.add(StackItem(NoteTypes.ITALIC_R, r, context, true))
                    return
                }
                else -> continue
            }
        }
        stack.add(StackItem(NoteTypes.ITALIC_L, r, context, false))
    }

    private fun matchesBold(r: MatchResult) {
        for (item in stack.asReversed()) {
            when (item.token) {
                NoteTypes.BREAK_PART,
                NoteTypes.BOLD_R -> {
                    stack.add(StackItem(NoteTypes.BOLD_L, r, context, false))
                    return
                }
                NoteTypes.BOLD_L -> {
                    item.setPaired()
                    stack.add(StackItem(NoteTypes.BOLD_R, r, context, true))
                    return
                }
                else -> continue
            }
        }
        stack.add(StackItem(NoteTypes.BOLD_L, r, context, false))
    }

    private fun matchesStrong(r: MatchResult) {
        for (item in stack.asReversed()) {
            when (item.token) {
                NoteTypes.BREAK_PART,
                NoteTypes.STRONG_R -> {
                    stack.add(StackItem(NoteTypes.STRONG_L, r, context, false))
                    return
                }
                NoteTypes.STRONG_L -> {
                    item.setPaired()
                    stack.add(StackItem(NoteTypes.STRONG_R, r, context, true))
                    return
                }
                else -> continue
            }
        }
        stack.add(StackItem(NoteTypes.STRONG_L, r, context))
    }

    private fun matchesTilde(): Boolean {
        val r = TILDE.matchAt(buffer, startOffset) ?: return false
        when (r.value.length) {
            1 -> matchUnderline(r)
            2 -> matchWave(r)
            3 -> matchStrike(r)
            else -> stack.add(StackItem(NoteTypes.PLAIN_TEXT, r, context))
        }
        return addOffset(r)
    }

    private fun matchUnderline(r: MatchResult) {
        for (item in stack.asReversed()) {
            when (item.token) {
                NoteTypes.BREAK_PART,
                NoteTypes.UNDER_R -> {
                    stack.add(StackItem(NoteTypes.UNDER_L, r, context, false))
                    return
                }
                NoteTypes.UNDER_L -> {
                    item.setPaired()
                    stack.add(StackItem(NoteTypes.UNDER_R, r, context, true))
                    return
                }
                else -> continue
            }
        }
        stack.add(StackItem(NoteTypes.UNDER_L, r, context, false))
    }

    private fun matchWave(r: MatchResult) {
        for (item in stack.asReversed()) {
            when (item.token) {
                NoteTypes.BREAK_PART,
                NoteTypes.WAVE_R -> {
                    stack.add(StackItem(NoteTypes.WAVE_L, r, context, false))
                    return
                }
                NoteTypes.WAVE_L -> {
                    item.setPaired()
                    stack.add(StackItem(NoteTypes.WAVE_R, r, context, true))
                    return
                }
                else -> continue
            }
        }
        stack.add(StackItem(NoteTypes.WAVE_L, r, context, false))
    }

    private fun matchStrike(r: MatchResult) {
        for (item in stack.asReversed()) {
            when (item.token) {
                NoteTypes.BREAK_PART,
                NoteTypes.STRIKE_R -> {
                    stack.add(StackItem(NoteTypes.STRIKE_L, r, context, false))
                    return
                }
                NoteTypes.STRIKE_L -> {
                    item.setPaired()
                    stack.add(StackItem(NoteTypes.STRIKE_R, r, context, true))
                    return
                }
                else -> continue
            }
        }
        stack.add(StackItem(NoteTypes.STRIKE_L, r, context, false))
    }

    private fun finalCatchText(): Boolean {
        val final = "[^\\\\＼$＄\\r\\n_＿]+".toRegex()
        val r = final.matchAt(buffer, startOffset) ?: return false
        stack.add(StackItem(NoteTypes.PLAIN_TEXT, r, context))
        return addOffset(r)
    }


    private fun checkRest() {
        if (startOffset < endOffset) {
            stack.add(StackItem(NoteTypes.PLAIN_TEXT, startOffset, endOffset, context))
        }
    }

    fun addOffset(r: MatchResult): Boolean {
        startOffset = r.range.last + 1
        return true
    }
}