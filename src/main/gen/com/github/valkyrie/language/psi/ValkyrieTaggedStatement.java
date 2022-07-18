// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyrieTaggedStatement extends PsiElement {

  @NotNull
  ValkyrieModifierSymbols getModifierSymbols();

  @NotNull
  ValkyrieTaggedBlock getTaggedBlock();

  @Nullable
  ValkyrieTypeAngle getTypeAngle();

  @NotNull
  ValkyrieIdentifier getSymbol();

  @NotNull
  ValkyrieIdentifier[] getModifiers();

}
