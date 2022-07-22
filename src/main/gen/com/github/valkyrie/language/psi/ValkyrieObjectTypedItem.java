// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyrieObjectTypedItem extends PsiElement {

  @NotNull
  ValkyrieClassKey getClassKey();

  @Nullable
  ValkyrieExpression getExpression();

  @Nullable
  ValkyrieTypeExpression getTypeExpression();

}
