// Copyright 2000-2023 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package emscriptintellijplugin;

import com.intellij.lang.ASTNode;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import emscriptintellijplugin.parser.EmsParser;
import emscriptintellijplugin.psi.EmsFile;
import emscriptintellijplugin.psi.EmsTokenSets;
import emscriptintellijplugin.psi.EmsTypes;
import org.jetbrains.annotations.NotNull;

final class EmsParserDefinition implements ParserDefinition {

  public static final IFileElementType FILE = new IFileElementType(EmsLanguage.INSTANCE);

  @NotNull
  @Override
  public Lexer createLexer(Project project) {
    return new EmsLexerAdapter();
  }

  @NotNull
  @Override
  public TokenSet getCommentTokens() {
    return EmsTokenSets.COMMENTS;
  }

  @NotNull
  @Override
  public TokenSet getStringLiteralElements() {
    return TokenSet.EMPTY;
  }

  @NotNull
  @Override
  public PsiParser createParser(final Project project) {
    return new EmsParser();
  }

  @NotNull
  @Override
  public IFileElementType getFileNodeType() {
    return FILE;
  }

  @NotNull
  @Override
  public PsiFile createFile(@NotNull FileViewProvider viewProvider) {
    return new EmsFile(viewProvider);
  }

  @NotNull
  @Override
  public PsiElement createElement(ASTNode node) {
    return EmsTypes.Factory.createElement(node);
  }

}
