// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyriePair extends PsiElement {

  @Nullable
  ValkyrieBoolean getBoolean();

  @NotNull
  ValkyrieExpression getExpression();

  @Nullable
  ValkyrieNamepath getNamepath();

  @Nullable
  ValkyrieNumber getNumber();

  @Nullable
  ValkyrieString getString();

}
