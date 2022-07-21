// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyrieDefineItem extends PsiElement {

  @Nullable
  ValkyrieExpression getExpression();

  @Nullable
  ValkyrieIdentifier getIdentifier();

  @NotNull
  List<ValkyrieMacroCall> getMacroCallList();

  @Nullable
  ValkyrieModifiers getModifiers();

  @Nullable
  ValkyrieTypeExpression getTypeExpression();

}
