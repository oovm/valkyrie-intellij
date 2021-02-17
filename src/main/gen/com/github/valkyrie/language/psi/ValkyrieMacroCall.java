// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyrieMacroCall extends PsiElement {

  @NotNull
  List<ValkyrieExpr> getExprList();

  @NotNull
  ValkyrieMacro getMacro();

  @NotNull
  List<ValkyriePair> getPairList();

}
