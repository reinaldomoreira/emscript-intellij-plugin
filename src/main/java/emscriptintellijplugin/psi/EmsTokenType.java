// Copyright 2000-2022 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package emscriptintellijplugin.psi;

import com.intellij.psi.tree.IElementType;
import emscriptintellijplugin.EmsLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class EmsTokenType extends IElementType {

  public EmsTokenType(@NotNull @NonNls String debugName) {
    super(debugName, EmsLanguage.INSTANCE);
  }

  @Override
  public String toString() {
    return "EmsTokenType." + super.toString();
  }

}
