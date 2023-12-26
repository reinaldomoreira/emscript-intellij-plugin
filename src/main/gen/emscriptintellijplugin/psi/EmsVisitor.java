// This is a generated file. Not intended for manual editing.
package emscriptintellijplugin.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;

public class EmsVisitor extends PsiElementVisitor {

  public void visitProperty(@NotNull EmsProperty o) {
    visitNamedElement(o);
  }

  public void visitNamedElement(@NotNull EmsNamedElement o) {
    visitPsiElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
