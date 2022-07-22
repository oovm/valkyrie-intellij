// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyrieExtendsStatement extends PsiElement {

  @NotNull
  ValkyrieIdentifier getIdentifier();

  @NotNull
  ValkyrieKwExtends getKwExtends();

  @Nullable
  ValkyrieModifiers getModifiers();

  @NotNull
  ValkyrieTraitBlock getTraitBlock();

  @Nullable
  ValkyrieTypeExpression getTypeExpression();

  @NotNull
  List<ValkyrieTypeGeneric> getTypeGenericList();

}
