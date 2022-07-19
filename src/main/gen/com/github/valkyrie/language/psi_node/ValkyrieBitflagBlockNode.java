// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi_node;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.github.valkyrie.language.psi.ValkyrieTypes.*;
import com.github.valkyrie.language.ast.ValkyrieElement;
import com.github.valkyrie.language.psi.*;
import com.github.valkyrie.language.ast.ASTMethods;

public class ValkyrieBitflagBlockNode extends ValkyrieElement implements ValkyrieBitflagBlock {

  public ValkyrieBitflagBlockNode(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ValkyrieVisitor visitor) {
    visitor.visitBitflagBlock(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<ValkyrieBitflagItem> getBitflagItemList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieBitflagItem.class);
  }

  @Override
  @NotNull
  public List<ValkyrieMacroCall> getMacroCallList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieMacroCall.class);
  }

}
