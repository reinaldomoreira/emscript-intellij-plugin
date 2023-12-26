// Copyright 2000-2022 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.

package emscriptintellijplugin;

import com.intellij.ide.structureView.StructureViewModel;
import com.intellij.ide.structureView.StructureViewModelBase;
import com.intellij.ide.structureView.StructureViewTreeElement;
import com.intellij.ide.util.treeView.smartTree.Sorter;
import com.intellij.openapi.editor.Editor;
import com.intellij.psi.PsiFile;
import emscriptintellijplugin.psi.EmsProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class EmsStructureViewModel extends StructureViewModelBase implements
    StructureViewModel.ElementInfoProvider {

  public EmsStructureViewModel(@Nullable Editor editor, PsiFile psiFile) {
    super(psiFile, editor, new EmsStructureViewElement(psiFile));
  }

  @NotNull
  public Sorter @NotNull [] getSorters() {
    return new Sorter[]{Sorter.ALPHA_SORTER};
  }


  @Override
  public boolean isAlwaysShowsPlus(StructureViewTreeElement element) {
    return false;
  }

  @Override
  public boolean isAlwaysLeaf(StructureViewTreeElement element) {
    return element.getValue() instanceof EmsProperty;
  }

  @Override
  protected Class<?> @NotNull [] getSuitableClasses() {
    return new Class[]{EmsProperty.class};
  }

}
