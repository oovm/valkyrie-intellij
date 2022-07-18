// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyrieNormalPattern extends PsiElement {

  @Nullable
  ValkyrieBraceBlock getBraceBlock();

  @NotNull
  List<ValkyrieIdentifier> getIdentifierList();

  @NotNull
  List<ValkyriePatternItem> getPatternItemList();

  @NotNull
  List<ValkyriePatternPair> getPatternPairList();

}
