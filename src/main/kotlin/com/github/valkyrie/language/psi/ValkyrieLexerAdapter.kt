package com.github.valkyrie.language.psi

import com.github.valkyrie.language._ValkyrieLexer
import com.intellij.lexer.FlexAdapter

class ValkyrieLexerAdapter : FlexAdapter(_ValkyrieLexer())
