// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.github.valkyrie.ide.highlight.ValkyrieHighlightColor;

public interface ValkyrieDefItem extends PsiElement {

  @Nullable
  ValkyrieDefItemSign getDefItemSign();

  @Nullable
  ValkyrieExpression getExpression();

  @Nullable
  ValkyrieIdentifier getIdentifier();

  @Nullable
  ValkyrieModifierSymbols getModifierSymbols();

  @Nullable
  ValkyrieTypeExpression getTypeExpression();

  @NotNull
  ValkyrieIdentifier getSymbol();

  @NotNull
  ValkyrieIdentifier[] getModifiers();

  @NotNull
  ValkyrieHighlightColor getSymbolColor();

}
