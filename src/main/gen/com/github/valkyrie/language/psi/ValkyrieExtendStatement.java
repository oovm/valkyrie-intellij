// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyrieExtendStatement extends PsiElement {

  @NotNull
  ValkyrieKwExtends getKwExtends();

  @NotNull
  ValkyrieModifiers getModifiers();

  @NotNull
  ValkyrieTraitBlock getTraitBlock();

  @Nullable
  ValkyrieTypeAngle getTypeAngle();

  @Nullable
  ValkyrieTypeExpression getTypeExpression();

}
