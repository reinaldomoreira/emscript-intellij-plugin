// Copyright 2000-2022 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package emscriptintellijplugin.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import emscriptintellijplugin.EmsFileType;
import emscriptintellijplugin.EmsLanguage;
import org.jetbrains.annotations.NotNull;

public class EmsFile extends PsiFileBase {

  public EmsFile(@NotNull FileViewProvider viewProvider) {
    super(viewProvider, EmsLanguage.INSTANCE);
  }

  @NotNull
  @Override
  public FileType getFileType() {
    return EmsFileType.INSTANCE;
  }

  @Override
  public String toString() {
    return "Ems File";
  }

}
