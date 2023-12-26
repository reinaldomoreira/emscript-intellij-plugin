// Copyright 2000-2023 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.

package emscriptintellijplugin;

import com.intellij.lang.ASTNode;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiComment;
import com.intellij.psi.PsiElement;
import com.intellij.spellchecker.inspections.CommentSplitter;
import com.intellij.spellchecker.inspections.IdentifierSplitter;
import com.intellij.spellchecker.inspections.PlainTextSplitter;
import com.intellij.spellchecker.tokenizer.SpellcheckingStrategy;
import com.intellij.spellchecker.tokenizer.TokenConsumer;
import com.intellij.spellchecker.tokenizer.Tokenizer;
import emscriptintellijplugin.psi.EmsProperty;
import emscriptintellijplugin.psi.EmsTypes;
import org.jetbrains.annotations.NotNull;

final class EmsSpellcheckingStrategy extends SpellcheckingStrategy {

  @Override
  public @NotNull Tokenizer<?> getTokenizer(PsiElement element) {
    if (element instanceof PsiComment) {
      return new EmsCommentTokenizer();
    }

    if (element instanceof EmsProperty) {
      return new EmsPropertyTokenizer();
    }

    return EMPTY_TOKENIZER;
  }

  private static class EmsCommentTokenizer extends Tokenizer<PsiComment> {

    @Override
    public void tokenize(@NotNull PsiComment element, TokenConsumer consumer) {
      // Exclude the start of the comment with its # characters from spell checking
      int startIndex = 0;
      for (char c : element.textToCharArray()) {
        if (c == '#' || Character.isWhitespace(c)) {
          startIndex++;
        } else {
          break;
        }
      }
      consumer.consumeToken(element, element.getText(), false, 0,
          TextRange.create(startIndex, element.getTextLength()),
          CommentSplitter.getInstance());
    }

  }

  private static class EmsPropertyTokenizer extends Tokenizer<EmsProperty> {

    public void tokenize(@NotNull EmsProperty element, TokenConsumer consumer) {
      //Spell check the keys and values of properties with different splitters
      final ASTNode key = element.getNode().findChildByType(EmsTypes.KEY);
      if (key != null && key.getTextLength() > 0) {
        final PsiElement keyPsi = key.getPsi();
        final String text = key.getText();
        //For keys, use a splitter for identifiers
        //Note we set "useRename" to true so that keys will be properly refactored (renamed)
        consumer.consumeToken(keyPsi, text, true, 0,
            TextRange.allOf(text), IdentifierSplitter.getInstance());
      }

      final ASTNode value = element.getNode().findChildByType(EmsTypes.VALUE);
      if (value != null && value.getTextLength() > 0) {
        final PsiElement valuePsi = value.getPsi();
        final String text = valuePsi.getText();
        //For values, use a splitter for plain text
        consumer.consumeToken(valuePsi, text, false, 0,
            TextRange.allOf(text), PlainTextSplitter.getInstance());
      }
    }

  }

}
