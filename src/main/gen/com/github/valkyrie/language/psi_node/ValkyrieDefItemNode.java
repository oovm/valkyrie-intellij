// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi_node;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.github.valkyrie.language.psi.ValkyrieTypes.*;
import com.github.valkyrie.language.mixin.MixinDefineItem;
import com.github.valkyrie.language.psi.*;
import com.github.valkyrie.language.ast.ASTMethods;
import com.github.valkyrie.ide.highlight.ValkyrieHighlightColor;

public class ValkyrieDefItemNode extends MixinDefineItem implements ValkyrieDefItem {

  public ValkyrieDefItemNode(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ValkyrieVisitor visitor) {
    visitor.visitDefItem(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public ValkyrieDefItemSign getDefItemSign() {
    return findChildByClass(ValkyrieDefItemSign.class);
  }

  @Override
  @Nullable
  public ValkyrieExpression getExpression() {
    return findChildByClass(ValkyrieExpression.class);
  }

  @Override
  @Nullable
  public ValkyrieIdentifier getIdentifier() {
    return findChildByClass(ValkyrieIdentifier.class);
  }

  @Override
  @Nullable
  public ValkyrieModifierSymbols getModifierSymbols() {
    return findChildByClass(ValkyrieModifierSymbols.class);
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
  @NotNull
  public ValkyrieHighlightColor getSymbolColor() {
    return ASTMethods.getSymbolColor(this);
  }

}
