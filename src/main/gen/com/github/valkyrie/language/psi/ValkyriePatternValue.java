// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyriePatternValue extends PsiElement {

  @Nullable
  ValkyrieBraceBlock getBraceBlock();

  @Nullable
  ValkyrieBracketBlock getBracketBlock();

  @Nullable
  ValkyrieIdentifier getIdentifier();

  @Nullable
  ValkyrieParenthesis getParenthesis();

}
