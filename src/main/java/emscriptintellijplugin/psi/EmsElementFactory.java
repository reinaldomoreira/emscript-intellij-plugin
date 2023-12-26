// Copyright 2000-2022 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package emscriptintellijplugin.psi;

import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFileFactory;

import emscriptintellijplugin.EmsFileType;

public class EmsElementFactory {

  public static EmsProperty createProperty(Project project, String name) {
    final EmsFile file = createFile(project, name);
    return (EmsProperty) file.getFirstChild();
  }

  public static EmsFile createFile(Project project, String text) {
    String name = "dummy.ems";
    return (EmsFile) PsiFileFactory.getInstance(project).createFileFromText(name, EmsFileType.INSTANCE, text);
  }

  public static EmsProperty createProperty(Project project, String name, String value) {
    final EmsFile file = createFile(project, name + " = " + value);
    return (EmsProperty) file.getFirstChild();
  }

  public static PsiElement createCRLF(Project project) {
    final EmsFile file = createFile(project, "\n");
    return file.getFirstChild();
  }

}
