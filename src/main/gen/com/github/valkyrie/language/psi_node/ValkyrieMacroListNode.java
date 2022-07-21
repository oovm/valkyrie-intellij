// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi_node;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.github.valkyrie.language.psi.ValkyrieTypes.*;
import com.github.valkyrie.language.ast.ValkyrieASTBase;
import com.github.valkyrie.language.psi.*;
import com.github.valkyrie.language.ast.ASTMethods;

public class ValkyrieMacroListNode extends ValkyrieASTBase implements ValkyrieMacroList {

  public ValkyrieMacroListNode(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ValkyrieVisitor visitor) {
    visitor.visitMacroList(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<ValkyrieMacroItem> getMacroItemList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieMacroItem.class);
  }

  @Override
  @NotNull
  public List<ValkyrieNamepath> getNamepathList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieNamepath.class);
  }

}
