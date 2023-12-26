// Copyright 2000-2023 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package emscriptintellijplugin;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public final class EmsFileType extends LanguageFileType {

  public static final EmsFileType INSTANCE = new EmsFileType();

  private EmsFileType() {
    super(EmsLanguage.INSTANCE);
  }

  @NotNull
  @Override
  public String getName() {
    return "Ems File";
  }

  @NotNull
  @Override
  public String getDescription() {
    return "Ems language file";
  }

  @NotNull
  @Override
  public String getDefaultExtension() {
    return "ems";
  }

  @Nullable
  @Override
  public Icon getIcon() {
    return EmsIcons.FILE;
  }

}
