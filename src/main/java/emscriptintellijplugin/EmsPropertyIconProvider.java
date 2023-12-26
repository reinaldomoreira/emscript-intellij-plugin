// Copyright 2000-2023 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.

package emscriptintellijplugin;

import com.intellij.ide.IconProvider;
import com.intellij.psi.PsiElement;
import emscriptintellijplugin.psi.EmsProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

final class EmsPropertyIconProvider extends IconProvider {

  @Override
  public @Nullable Icon getIcon(@NotNull PsiElement element, int flags) {
    return element instanceof EmsProperty ? EmsIcons.FILE : null;
  }

}
