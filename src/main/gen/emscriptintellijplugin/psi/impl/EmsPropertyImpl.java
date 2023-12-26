// This is a generated file. Not intended for manual editing.
package emscriptintellijplugin.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static emscriptintellijplugin.psi.EmsTypes.*;
import emscriptintellijplugin.psi.*;
import com.intellij.navigation.ItemPresentation;

public class EmsPropertyImpl extends EmsNamedElementImpl implements EmsProperty {

  public EmsPropertyImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull EmsVisitor visitor) {
    visitor.visitProperty(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof EmsVisitor) accept((EmsVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  public String getKey() {
    return EmsPsiImplUtil.getKey(this);
  }

  @Override
  public String getValue() {
    return EmsPsiImplUtil.getValue(this);
  }

  @Override
  public String getName() {
    return EmsPsiImplUtil.getName(this);
  }

  @Override
  public PsiElement setName(String newName) {
    return EmsPsiImplUtil.setName(this, newName);
  }

  @Override
  public PsiElement getNameIdentifier() {
    return EmsPsiImplUtil.getNameIdentifier(this);
  }

  @Override
  public ItemPresentation getPresentation() {
    return EmsPsiImplUtil.getPresentation(this);
  }

}
