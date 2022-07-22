// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyrieClassItem extends PsiElement {

  @Nullable
  ValkyrieExpression getExpression();

  @Nullable
  ValkyrieModifiers getModifiers();

  @NotNull
  ValkyrieObjectKey getObjectKey();

  @Nullable
  ValkyrieTypeExpression getTypeExpression();

}
