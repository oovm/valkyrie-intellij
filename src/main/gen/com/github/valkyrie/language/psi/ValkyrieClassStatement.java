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

  //WARNING: getSymbol(...) is skipped
  //matching getSymbol(ValkyrieClassStatement, ...)
  //methods are not found in ASTMethods

  //WARNING: getModifiers(...) is skipped
  //matching getModifiers(ValkyrieClassStatement, ...)
  //methods are not found in ASTMethods

  //WARNING: getBraceItemList(...) is skipped
  //matching getBraceItemList(ValkyrieClassStatement, ...)
  //methods are not found in ASTMethods

  //WARNING: getTupleItemList(...) is skipped
  //matching getTupleItemList(ValkyrieClassStatement, ...)
  //methods are not found in ASTMethods

  //WARNING: isEmpty(...) is skipped
  //matching isEmpty(ValkyrieClassStatement, ...)
  //methods are not found in ASTMethods

}
