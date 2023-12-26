// Copyright 2000-2022 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package emscriptintellijplugin;

import com.google.common.collect.Lists;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiComment;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiManager;
import com.intellij.psi.PsiWhiteSpace;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.util.PsiTreeUtil;
import emscriptintellijplugin.psi.EmsFile;
import emscriptintellijplugin.psi.EmsProperty;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class EmsUtil {

  /**
   * Searches the entire project for Ems language files with instances of the Ems property with the given key.
   *
   * @param project current project
   * @param key     to check
   * @return matching properties
   */
  public static List<EmsProperty> findProperties(Project project, String key) {
    List<EmsProperty> result = new ArrayList<>();
    Collection<VirtualFile> virtualFiles =
        FileTypeIndex.getFiles(EmsFileType.INSTANCE, GlobalSearchScope.allScope(project));
    for (VirtualFile virtualFile : virtualFiles) {
      EmsFile emsFile = (EmsFile) PsiManager.getInstance(project).findFile(virtualFile);
      if (emsFile != null) {
        EmsProperty[] properties = PsiTreeUtil.getChildrenOfType(emsFile, EmsProperty.class);
        if (properties != null) {
          for (EmsProperty property : properties) {
            if (key.equals(property.getKey())) {
              result.add(property);
            }
          }
        }
      }
    }
    return result;
  }

  public static List<EmsProperty> findProperties(Project project) {
    List<EmsProperty> result = new ArrayList<>();
    Collection<VirtualFile> virtualFiles =
        FileTypeIndex.getFiles(EmsFileType.INSTANCE, GlobalSearchScope.allScope(project));
    for (VirtualFile virtualFile : virtualFiles) {
      EmsFile emsFile = (EmsFile) PsiManager.getInstance(project).findFile(virtualFile);
      if (emsFile != null) {
        EmsProperty[] properties = PsiTreeUtil.getChildrenOfType(emsFile, EmsProperty.class);
        if (properties != null) {
          Collections.addAll(result, properties);
        }
      }
    }
    return result;
  }

  /**
   * Attempts to collect any comment elements above the Ems key/value pair.
   */
  public static @NotNull String findDocumentationComment(EmsProperty property) {
    List<String> result = new LinkedList<>();
    PsiElement element = property.getPrevSibling();
    while (element instanceof PsiComment || element instanceof PsiWhiteSpace) {
      if (element instanceof PsiComment) {
        String commentText = element.getText().replaceFirst("[!# ]+", "");
        result.add(commentText);
      }
      element = element.getPrevSibling();
    }
    return StringUtil.join(Lists.reverse(result), "\n ");
  }

}
