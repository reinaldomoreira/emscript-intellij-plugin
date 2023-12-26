// Copyright 2000-2023 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.

package emscriptintellijplugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import emscriptintellijplugin.psi.EmsElementFactory;
import emscriptintellijplugin.psi.EmsProperty;
import emscriptintellijplugin.psi.EmsTypes;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class EmsPsiImplUtil {

  public static String getKey(EmsProperty element) {
    ASTNode keyNode = element.getNode().findChildByType(EmsTypes.KEY);
    if (keyNode != null) {
      // IMPORTANT: Convert embedded escaped spaces to ems spaces
      return keyNode.getText().replaceAll("\\\\ ", " ");
    } else {
      return null;
    }
  }

  public static String getValue(EmsProperty element) {
    ASTNode valueNode = element.getNode().findChildByType(EmsTypes.VALUE);
    if (valueNode != null) {
      return valueNode.getText();
    } else {
      return null;
    }
  }

  public static String getName(EmsProperty element) {
    return getKey(element);
  }

  public static PsiElement setName(EmsProperty element, String newName) {
    ASTNode keyNode = element.getNode().findChildByType(EmsTypes.KEY);
    if (keyNode != null) {
      EmsProperty property = EmsElementFactory.createProperty(element.getProject(), newName);
      ASTNode newKeyNode = property.getFirstChild().getNode();
      element.getNode().replaceChild(keyNode, newKeyNode);
    }
    return element;
  }

  public static PsiElement getNameIdentifier(EmsProperty element) {
    ASTNode keyNode = element.getNode().findChildByType(EmsTypes.KEY);
    if (keyNode != null) {
      return keyNode.getPsi();
    } else {
      return null;
    }
  }

  public static ItemPresentation getPresentation(final EmsProperty element) {
    return new ItemPresentation() {
      @Nullable
      @Override
      public String getPresentableText() {
        return element.getKey();
      }

      @Nullable
      @Override
      public String getLocationString() {
        PsiFile containingFile = element.getContainingFile();
        return containingFile == null ? null : containingFile.getName();
      }

      @Override
      public Icon getIcon(boolean unused) {
        return element.getIcon(0);
      }
    };
  }

}
