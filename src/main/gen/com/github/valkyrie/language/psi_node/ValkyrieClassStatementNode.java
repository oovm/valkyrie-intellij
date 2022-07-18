// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi_node;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.github.valkyrie.language.psi.ValkyrieTypes.*;
import com.github.valkyrie.language.mixin.MixinClass;
import com.github.valkyrie.language.psi.*;
import com.github.valkyrie.language.ast.ASTMethods;

public class ValkyrieClassStatementNode extends MixinClass implements ValkyrieClassStatement {

  public ValkyrieClassStatementNode(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ValkyrieVisitor visitor) {
    visitor.visitClassStatement(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public ValkyrieClassBrace getClassBrace() {
    return findChildByClass(ValkyrieClassBrace.class);
  }

  @Override
  @Nullable
  public ValkyrieClassTuple getClassTuple() {
    return findChildByClass(ValkyrieClassTuple.class);
  }

  @Override
  @Nullable
  public ValkyrieIdentifier getIdentifier() {
    return findChildByClass(ValkyrieIdentifier.class);
  }

  @Override
  @NotNull
  public ValkyrieModifierSymbols getModifierSymbols() {
    return findNotNullChildByClass(ValkyrieModifierSymbols.class);
  }

  @Override
  @Nullable
  public ValkyrieTypeAngle getTypeAngle() {
    return findChildByClass(ValkyrieTypeAngle.class);
  }

  @Override
  @NotNull
  public ValkyrieIdentifier getSymbol() {
    return ASTMethods.getSymbol(this);
  }

  @Override
  @NotNull
  public ValkyrieIdentifier[] getModifiers() {
    return ASTMethods.getModifiers(this);
  }

  @Override
  @NotNull
  public ValkyrieClassBraceItem[] getBraceItemList() {
    return ASTMethods.getBraceItemList(this);
  }

  @Override
  @NotNull
  public ValkyrieClassTupleItem[] getTupleItemList() {
    return ASTMethods.getTupleItemList(this);
  }

  @Override
  public boolean isEmpty() {
    return ASTMethods.isEmpty(this);
  }

}
