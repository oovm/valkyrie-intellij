// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyrieClassDefine extends PsiElement {

  @NotNull
  ValkyrieIdentifier getIdentifier();

  @Nullable
  ValkyrieObjectBlock getObjectBlock();

  @NotNull
  ValkyrieTuple getTuple();

  @Nullable
  ValkyrieTypeExpression getTypeExpression();

}
