// Copyright 2000-2022 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package emscriptintellijplugin;

import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.codeStyle.CustomCodeStyleSettings;

public class EmsCodeStyleSettings extends CustomCodeStyleSettings {

  public EmsCodeStyleSettings(CodeStyleSettings settings) {
    super("EmsCodeStyleSettings", settings);
  }

}
