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

public class ValkyrieDefineStatementNode extends MixinDefine implements ValkyrieDefineStatement {

  public ValkyrieDefineStatementNode(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ValkyrieVisitor visitor) {
    visitor.visitDefineStatement(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public ValkyrieDefineBlock getDefineBlock() {
    return findChildByClass(ValkyrieDefineBlock.class);
  }

  @Override
  @NotNull
  public ValkyrieDefineTuple getDefineTuple() {
    return findNotNullChildByClass(ValkyrieDefineTuple.class);
  }

  @Override
  @Nullable
  public ValkyrieExpression getExpression() {
    return findChildByClass(ValkyrieExpression.class);
  }

  @Override
  @Nullable
  public ValkyrieGenericDefine getGenericDefine() {
    return findChildByClass(ValkyrieGenericDefine.class);
  }

  @Override
  @NotNull
  public ValkyrieKwDefine getKwDefine() {
    return findNotNullChildByClass(ValkyrieKwDefine.class);
  }

  @Override
  @Nullable
  public ValkyrieModifiers getModifiers() {
    return findChildByClass(ValkyrieModifiers.class);
  }

  @Override
  @NotNull
  public ValkyrieNamepathFree getNamepathFree() {
    return findNotNullChildByClass(ValkyrieNamepathFree.class);
  }

  @Override
  @Nullable
  public ValkyrieTypeExpression getTypeExpression() {
    return findChildByClass(ValkyrieTypeExpression.class);
  }

}
