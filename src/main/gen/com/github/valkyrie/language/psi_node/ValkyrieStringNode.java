// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi_node;

import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.github.valkyrie.language.ast.ValkyrieElement;
import com.github.valkyrie.language.psi.*;

public class ValkyrieStringNode extends ValkyrieElement implements ValkyrieString {

  public ValkyrieStringNode(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ValkyrieVisitor visitor) {
    visitor.visitString(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public ValkyrieStringLiteral getStringLiteral() {
    return findNotNullChildByClass(ValkyrieStringLiteral.class);
  }

  @Override
  @Nullable
  public ValkyrieSymbol getSymbol() {
    return findChildByClass(ValkyrieSymbol.class);
  }

}
