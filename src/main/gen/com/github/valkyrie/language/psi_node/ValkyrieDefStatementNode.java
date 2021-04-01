// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi_node;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.github.valkyrie.language.psi.ValkyrieTypes.*;
import com.github.valkyrie.language.mixin.MixinDefine;
import com.github.valkyrie.language.psi.*;
import com.github.valkyrie.language.ast.ASTMethods;

public class ValkyrieDefStatementNode extends MixinDefine implements ValkyrieDefStatement {

  public ValkyrieDefStatementNode(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ValkyrieVisitor visitor) {
    visitor.visitDefStatement(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public ValkyrieDefBlock getDefBlock() {
    return findChildByClass(ValkyrieDefBlock.class);
  }

  @Override
  @NotNull
  public ValkyrieDefTuple getDefTuple() {
    return findNotNullChildByClass(ValkyrieDefTuple.class);
  }

  @Override
  @Nullable
  public ValkyrieExpression getExpression() {
    return findChildByClass(ValkyrieExpression.class);
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
  @Nullable
  public ValkyrieTypeExpression getTypeExpression() {
    return findChildByClass(ValkyrieTypeExpression.class);
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
  public boolean isMethod() {
    return ASTMethods.isMethod(this);
  }

}
