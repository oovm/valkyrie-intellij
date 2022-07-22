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

public class ValkyrieTypeExpressionNode extends ValkyrieASTBase implements ValkyrieTypeExpression {

  public ValkyrieTypeExpressionNode(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ValkyrieVisitor visitor) {
    visitor.visitTypeExpression(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<ValkyrieBoolean> getBooleanList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieBoolean.class);
  }

  @Override
  @NotNull
  public List<ValkyrieCallSuffix> getCallSuffixList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieCallSuffix.class);
  }

  @Override
  @NotNull
  public List<ValkyrieList> getListList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieList.class);
  }

  @Override
  @NotNull
  public List<ValkyrieNamepath> getNamepathList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieNamepath.class);
  }

  @Override
  @NotNull
  public List<ValkyrieNumber> getNumberList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieNumber.class);
  }

  @Override
  @NotNull
  public List<ValkyrieRange> getRangeList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieRange.class);
  }

  @Override
  @NotNull
  public List<ValkyrieSlice> getSliceList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieSlice.class);
  }

  @Override
  @NotNull
  public List<ValkyrieString> getStringList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieString.class);
  }

  @Override
  @NotNull
  public List<ValkyrieTuple> getTupleList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieTuple.class);
  }

  @Override
  @NotNull
  public List<ValkyrieTypeGeneric> getTypeGenericList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieTypeGeneric.class);
  }

}
