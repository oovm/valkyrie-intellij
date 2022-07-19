// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyrieMacroItem extends PsiElement {

  @NotNull
  List<ValkyrieExpression> getExpressionList();

  @NotNull
  List<ValkyriePair> getPairList();

}
