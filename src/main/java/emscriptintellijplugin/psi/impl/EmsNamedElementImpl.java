// Copyright 2000-2022 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package emscriptintellijplugin.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import emscriptintellijplugin.psi.EmsNamedElement;
import org.jetbrains.annotations.NotNull;

public abstract class EmsNamedElementImpl extends ASTWrapperPsiElement implements EmsNamedElement {

  public EmsNamedElementImpl(@NotNull ASTNode node) {
    super(node);
  }

}
