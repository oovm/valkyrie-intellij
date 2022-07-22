// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyrieDefineStatement extends PsiElement {

  @Nullable
  ValkyrieDefineBlock getDefineBlock();

  @NotNull
  ValkyrieDefineTuple getDefineTuple();

  @Nullable
  ValkyrieExpression getExpression();

  @Nullable
  ValkyrieGenericDefine getGenericDefine();

  @NotNull
  ValkyrieKwDefine getKwDefine();

  @Nullable
  ValkyrieModifiers getModifiers();

  @NotNull
  ValkyrieNamepathFree getNamepathFree();

  @Nullable
  ValkyrieTypeExpression getTypeExpression();

}
