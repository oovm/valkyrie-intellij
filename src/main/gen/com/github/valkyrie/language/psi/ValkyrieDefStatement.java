// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyrieDefStatement extends PsiElement {

  @Nullable
  ValkyrieDefBlock getDefBlock();

  @NotNull
  ValkyrieDefTuple getDefTuple();

  @Nullable
  ValkyrieExpression getExpression();

  @NotNull
  ValkyrieModifierSymbols getModifierSymbols();

  @Nullable
  ValkyrieTypeAngle getTypeAngle();

  @Nullable
  ValkyrieTypeExpression getTypeExpression();

  //WARNING: getSymbol(...) is skipped
  //matching getSymbol(ValkyrieDefStatement, ...)
  //methods are not found in ASTMethods

  //WARNING: getModifiers(...) is skipped
  //matching getModifiers(ValkyrieDefStatement, ...)
  //methods are not found in ASTMethods

  //WARNING: isMethod(...) is skipped
  //matching isMethod(ValkyrieDefStatement, ...)
  //methods are not found in ASTMethods

}
