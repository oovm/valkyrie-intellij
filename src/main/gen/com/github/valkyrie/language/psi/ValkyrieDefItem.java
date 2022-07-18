// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

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

  //WARNING: getSymbol(...) is skipped
  //matching getSymbol(ValkyrieDefItem, ...)
  //methods are not found in ASTMethods

  //WARNING: getModifiers(...) is skipped
  //matching getModifiers(ValkyrieDefItem, ...)
  //methods are not found in ASTMethods

  //WARNING: getSymbolColor(...) is skipped
  //matching getSymbolColor(ValkyrieDefItem, ...)
  //methods are not found in ASTMethods

}
