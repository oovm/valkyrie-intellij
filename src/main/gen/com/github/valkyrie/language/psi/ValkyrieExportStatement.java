// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyrieExportStatement extends PsiElement {

  @NotNull
  ValkyrieImportBlock getImportBlock();

  @NotNull
  List<ValkyrieNamespace> getNamespaceList();

}
