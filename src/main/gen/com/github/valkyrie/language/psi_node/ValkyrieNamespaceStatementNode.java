// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi_node;

import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.github.valkyrie.language.mixin.MixinExtension;
import com.github.valkyrie.language.psi.*;

public class ValkyrieNamespaceStatementNode extends MixinExtension implements ValkyrieNamespaceStatement {

  public ValkyrieNamespaceStatementNode(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ValkyrieVisitor visitor) {
    visitor.visitNamespaceStatement(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public ValkyrieIdentifier getIdentifier() {
    return findNotNullChildByClass(ValkyrieIdentifier.class);
  }

}
