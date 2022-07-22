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

public class ValkyrieTopBlockNode extends ValkyrieASTBase implements ValkyrieTopBlock {

  public ValkyrieTopBlockNode(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ValkyrieVisitor visitor) {
    visitor.visitTopBlock(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<ValkyrieBitflagStatement> getBitflagStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieBitflagStatement.class);
  }

  @Override
  @NotNull
  public List<ValkyrieClassStatement> getClassStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieClassStatement.class);
  }

  @Override
  @NotNull
  public List<ValkyrieDefineStatement> getDefineStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieDefineStatement.class);
  }

  @Override
  @NotNull
  public List<ValkyrieExtendsStatement> getExtendsStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieExtendsStatement.class);
  }

  @Override
  @NotNull
  public List<ValkyrieExtensionStatement> getExtensionStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieExtensionStatement.class);
  }

  @Override
  @NotNull
  public List<ValkyrieImportStatement> getImportStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieImportStatement.class);
  }

  @Override
  @NotNull
  public List<ValkyrieNamespaceStatement> getNamespaceStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieNamespaceStatement.class);
  }

  @Override
  @NotNull
  public List<ValkyrieTaggedStatement> getTaggedStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieTaggedStatement.class);
  }

  @Override
  @NotNull
  public List<ValkyrieTraitStatement> getTraitStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieTraitStatement.class);
  }

}
