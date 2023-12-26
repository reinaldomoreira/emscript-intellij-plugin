// Copyright 2000-2023 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package emscriptintellijplugin;

import com.intellij.application.options.CodeStyleAbstractConfigurable;
import com.intellij.application.options.CodeStyleAbstractPanel;
import com.intellij.application.options.TabbedLanguageCodeStylePanel;
import com.intellij.psi.codeStyle.CodeStyleConfigurable;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.codeStyle.CodeStyleSettingsProvider;
import com.intellij.psi.codeStyle.CustomCodeStyleSettings;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class EmsCodeStyleSettingsProvider extends CodeStyleSettingsProvider {

  @Override
  public CustomCodeStyleSettings createCustomSettings(@NotNull CodeStyleSettings settings) {
    return new EmsCodeStyleSettings(settings);
  }

  @Nullable
  @Override
  public String getConfigurableDisplayName() {
    return "Ems";
  }

  @NotNull
  public CodeStyleConfigurable createConfigurable(@NotNull CodeStyleSettings settings,
                                                  @NotNull CodeStyleSettings modelSettings) {
    return new CodeStyleAbstractConfigurable(settings, modelSettings, this.getConfigurableDisplayName()) {
      @Override
      protected @NotNull CodeStyleAbstractPanel createPanel(@NotNull CodeStyleSettings settings) {
        return new EmsCodeStyleMainPanel(getCurrentSettings(), settings);
      }
    };
  }

  private static class EmsCodeStyleMainPanel extends TabbedLanguageCodeStylePanel {

    public EmsCodeStyleMainPanel(CodeStyleSettings currentSettings, CodeStyleSettings settings) {
      super(EmsLanguage.INSTANCE, currentSettings, settings);
    }

  }

}
