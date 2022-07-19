// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyrieIfStatement extends PsiElement {

  @NotNull
  ValkyrieCondition getCondition();

  @NotNull
  List<ValkyrieEfStatement> getEfStatementList();

  @Nullable
  ValkyrieElseStatement getElseStatement();

  @NotNull
  List<ValkyrieExpression> getExpressionList();

}
