// This is a generated file. Not intended for manual editing.
package emscriptintellijplugin.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import emscriptintellijplugin.psi.impl.*;

public interface EmsTypes {

  IElementType PROPERTY = new EmsElementType("PROPERTY");

  IElementType COMMENT = new EmsTokenType("COMMENT");
  IElementType CRLF = new EmsTokenType("CRLF");
  IElementType KEY = new EmsTokenType("KEY");
  IElementType SEPARATOR = new EmsTokenType("SEPARATOR");
  IElementType VALUE = new EmsTokenType("VALUE");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == PROPERTY) {
        return new EmsPropertyImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
