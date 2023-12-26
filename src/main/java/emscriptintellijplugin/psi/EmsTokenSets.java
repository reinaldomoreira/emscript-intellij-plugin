// Copyright 2000-2022 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.

package emscriptintellijplugin.psi;

import com.intellij.psi.tree.TokenSet;

public interface EmsTokenSets {

  TokenSet IDENTIFIERS = TokenSet.create(EmsTypes.KEY);

  TokenSet COMMENTS = TokenSet.create(EmsTypes.COMMENT);

}
