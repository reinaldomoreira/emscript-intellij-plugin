// This is a generated file. Not intended for manual editing.
package com.github.reinaldomoreira.emscriptintellijplugin.language.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.github.reinaldomoreira.emscriptintellijplugin.language.psi.impl.*;

public interface EMScriptTypes {

	IElementType PROPERTY = new EMScriptElementType("PROPERTY");

	IElementType COMMENT = new EMScriptTokenType("COMMENT");
	IElementType CRLF = new EMScriptTokenType("CRLF");
	IElementType KEY = new EMScriptTokenType("KEY");
	IElementType SEPARATOR = new EMScriptTokenType("SEPARATOR");
	IElementType VALUE = new EMScriptTokenType("VALUE");
	IElementType BAD_CHARACTER = new EMScriptTokenType("BAD_CHARACTER");

	class Factory {
		public static PsiElement createElement(ASTNode node) {
			IElementType type = node.getElementType();
			if (type == PROPERTY) {
				return new EMScriptPropertyImpl(node);
			}
			throw new AssertionError("Unknown element type: " + type);
		}
	}
}
