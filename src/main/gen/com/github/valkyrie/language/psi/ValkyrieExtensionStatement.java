// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyrieExtensionStatement extends PsiElement {

  @NotNull
  ValkyrieIdentifier getIdentifier();

  @NotNull
  ValkyrieKwExtension getKwExtension();

  @NotNull
  ValkyrieNamepathFree getNamepathFree();

  @NotNull
  ValkyrieTopBlock getTopBlock();

}
