// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyrieNormalPattern extends PsiElement {

  @Nullable
  ValkyrieBraceBlock getBraceBlock();

  @Nullable
  ValkyrieBracketBlock getBracketBlock();

  @NotNull
  List<ValkyrieIdentifier> getIdentifierList();

  @Nullable
  ValkyrieParenthesis getParenthesis();

  @Nullable
  ValkyrieSequence getSequence();

}
