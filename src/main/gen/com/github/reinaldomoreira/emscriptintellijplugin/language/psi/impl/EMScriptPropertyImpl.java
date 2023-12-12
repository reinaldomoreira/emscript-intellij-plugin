// This is a generated file. Not intended for manual editing.
package com.github.reinaldomoreira.emscriptintellijplugin.language.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.github.reinaldomoreira.emscriptintellijplugin.language.psi.EMScriptTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.github.reinaldomoreira.emscriptintellijplugin.language.psi.*;

public class EMScriptPropertyImpl extends ASTWrapperPsiElement implements EMScriptProperty {

  public EMScriptPropertyImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull EMScriptVisitor visitor) {
    visitor.visitProperty(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof EMScriptVisitor) accept((EMScriptVisitor)visitor);
    else super.accept(visitor);
  }

}
