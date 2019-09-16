/*
 * SonarQube Java
 * Copyright (C) 2012-2019 SonarSource SA
 * mailto:info AT sonarsource DOT com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package org.sonar.java.model;

import org.junit.jupiter.api.Test;
import org.sonar.java.bytecode.loader.SquidClassLoader;
import org.sonar.java.model.declaration.ClassTreeImpl;
import org.sonar.java.resolve.SemanticModel;

import java.io.File;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class JSymbolMetadataTest {

  @Test
  void should_convert_annotation_values() {
    JavaTree.CompilationUnitTreeImpl cu = test("import java.lang.annotation.*; @Target({ElementType.TYPE, ElementType.METHOD}) @interface A { }");
    ClassTreeImpl c = (ClassTreeImpl) cu.types().get(0);
    Object[] value = (Object[]) cu.sema.typeSymbol(c.typeBinding).metadata().annotations().get(0).values().get(0).value();
    assertThat(value).hasSize(2);
    assertThat(((JVariableSymbol) value[0]).isEnum()).isTrue();
    assertThat(((JVariableSymbol) value[1]).isEnum()).isTrue();
  }

  private JavaTree.CompilationUnitTreeImpl test(String source) {
    List<File> classpath = Collections.emptyList();
    JavaTree.CompilationUnitTreeImpl t = (JavaTree.CompilationUnitTreeImpl) JParser.parse(
      "12",
      "File.java",
      source,
      true,
      classpath
    );
    SemanticModel.createFor(t, new SquidClassLoader(classpath));
    return t;
  }

}
