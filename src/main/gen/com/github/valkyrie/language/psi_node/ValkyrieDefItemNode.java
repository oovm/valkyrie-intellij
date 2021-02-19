// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi_node;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.github.valkyrie.language.psi.ValkyrieTypes.*;
import com.github.valkyrie.language.psi.ValkyrieElement;
import com.github.valkyrie.language.psi.*;

public class ValkyrieDefItemNode extends ValkyrieElement implements ValkyrieDefItem {

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
  public ValkyrieExpression getExpression() {
    return findChildByClass(ValkyrieExpression.class);
  }

  @Override
  @NotNull
  public ValkyrieModifiers getModifiers() {
    return findNotNullChildByClass(ValkyrieModifiers.class);
  }

  @Override
  @Nullable
  public ValkyrieTypeExpression getTypeExpression() {
    return findChildByClass(ValkyrieTypeExpression.class);
  }

}