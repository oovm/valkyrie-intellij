// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyrieClassStatement extends PsiElement {

  @Nullable
  ValkyrieClassBrace getClassBrace();

  @Nullable
  ValkyrieClassTuple getClassTuple();

  @Nullable
  ValkyrieIdentifier getIdentifier();

  @NotNull
  ValkyrieModifierSymbols getModifierSymbols();

  @Nullable
  ValkyrieTypeAngle getTypeAngle();

  @NotNull
  ValkyrieIdentifier getSymbol();

  @NotNull
  ValkyrieIdentifier[] getModifiers();

  @NotNull
  ValkyrieClassBraceItem[] getBraceItemList();

  @NotNull
  ValkyrieClassTupleItem[] getTupleItemList();

  boolean isEmpty();

}
