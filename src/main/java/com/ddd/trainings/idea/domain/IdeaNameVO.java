package com.ddd.trainings.idea.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.jmolecules.ddd.annotation.ValueObject;

@ValueObject
@AllArgsConstructor
public class IdeaNameVO {

  @Getter
  private final String nameValue;

  public static IdeaNameVO from(String name) {
    if (name == null || name.length() < 10 || name.length() > 160) {
      throw new IllegalArgumentException("Name must be at least 10 characters long");
    } else {
      return new IdeaNameVO(name);
    }
  }

  public String[] getKeywords() {
    return nameValue.split(" ");
  }
}
