// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyrieForStatement extends PsiElement {

  @NotNull
  ValkyrieBraceBlock getBraceBlock();

  @Nullable
  ValkyrieCasePattern getCasePattern();

  @Nullable
  ValkyrieElseStatement getElseStatement();

  @NotNull
  ValkyrieExpression getExpression();

  @Nullable
  ValkyrieIfGuard getIfGuard();

  @Nullable
  ValkyrieNormalPattern getNormalPattern();

}
