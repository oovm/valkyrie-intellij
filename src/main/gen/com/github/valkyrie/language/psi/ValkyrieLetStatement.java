// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyrieLetStatement extends PsiElement {

  @Nullable
  ValkyrieCasePattern getCasePattern();

  @NotNull
  List<ValkyrieExpr> getExprList();

  @Nullable
  ValkyrieLetTypeHint getLetTypeHint();

  @Nullable
  ValkyrieNormalPattern getNormalPattern();

}
