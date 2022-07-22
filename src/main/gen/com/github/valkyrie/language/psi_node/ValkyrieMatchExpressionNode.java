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

public class ValkyrieMatchExpressionNode extends ValkyrieASTBase implements ValkyrieMatchExpression {

  public ValkyrieMatchExpressionNode(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ValkyrieVisitor visitor) {
    visitor.visitMatchExpression(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public ValkyrieCasePattern getCasePattern() {
    return findNotNullChildByClass(ValkyrieCasePattern.class);
  }

  @Override
  @NotNull
  public List<ValkyrieExpression> getExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieExpression.class);
  }

  @Override
  @NotNull
  public List<ValkyrieForStatement> getForStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieForStatement.class);
  }

  @Override
  @NotNull
  public List<ValkyrieForallStatement> getForallStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieForallStatement.class);
  }

  @Override
  @NotNull
  public List<ValkyrieIfStatement> getIfStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieIfStatement.class);
  }

  @Override
  @NotNull
  public List<ValkyrieLetStatement> getLetStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieLetStatement.class);
  }

  @Override
  @NotNull
  public List<ValkyrieMatchStatement> getMatchStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieMatchStatement.class);
  }

  @Override
  @NotNull
  public List<ValkyrieNewStatement> getNewStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieNewStatement.class);
  }

  @Override
  @NotNull
  public List<ValkyrieTypeStatement> getTypeStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieTypeStatement.class);
  }

  @Override
  @NotNull
  public List<ValkyrieWhileStatement> getWhileStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieWhileStatement.class);
  }

}
