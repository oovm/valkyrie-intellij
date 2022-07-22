// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyrieTypeStatement extends PsiElement {

  @Nullable
  ValkyrieBoolean getBoolean();

  @NotNull
  List<ValkyrieCallSuffix> getCallSuffixList();

  @NotNull
  ValkyrieIdentifier getIdentifier();

  @Nullable
  ValkyrieList getList();

  @Nullable
  ValkyrieNamepath getNamepath();

  @Nullable
  ValkyrieNumber getNumber();

  @Nullable
  ValkyrieRange getRange();

  @NotNull
  List<ValkyrieSlice> getSliceList();

  @Nullable
  ValkyrieString getString();

  @Nullable
  ValkyrieTuple getTuple();

  @NotNull
  List<ValkyrieTypeGeneric> getTypeGenericList();

}
