// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi_node;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.github.valkyrie.language.psi.ValkyrieTypes.*;
import com.github.valkyrie.language.mixin.MixinBitflag;
import com.github.valkyrie.language.psi.*;
import com.github.valkyrie.language.ast.ASTMethods;

public class ValkyrieBitflagStatementNode extends MixinBitflag implements ValkyrieBitflagStatement {

  public ValkyrieBitflagStatementNode(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ValkyrieVisitor visitor) {
    visitor.visitBitflagStatement(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public ValkyrieBitflagBlock getBitflagBlock() {
    return findNotNullChildByClass(ValkyrieBitflagBlock.class);
  }

  @Override
  @Nullable
  public ValkyrieBitflagLayout getBitflagLayout() {
    return findChildByClass(ValkyrieBitflagLayout.class);
  }

  @Override
  @NotNull
  public ValkyrieModifiers getModifiers() {
    return findNotNullChildByClass(ValkyrieModifiers.class);
  }

}
