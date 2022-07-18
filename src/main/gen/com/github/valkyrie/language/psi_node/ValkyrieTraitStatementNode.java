// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi_node;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.github.valkyrie.language.psi.ValkyrieTypes.*;
import com.github.valkyrie.language.mixin.MixinTrait;
import com.github.valkyrie.language.psi.*;
import com.github.valkyrie.language.ast.ASTMethods;

public class ValkyrieTraitStatementNode extends MixinTrait implements ValkyrieTraitStatement {

  public ValkyrieTraitStatementNode(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ValkyrieVisitor visitor) {
    visitor.visitTraitStatement(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public ValkyrieModifierSymbols getModifierSymbols() {
    return findNotNullChildByClass(ValkyrieModifierSymbols.class);
  }

  @Override
  @NotNull
  public ValkyrieTraitBlock getTraitBlock() {
    return findNotNullChildByClass(ValkyrieTraitBlock.class);
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

}
