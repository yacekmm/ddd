package com.ddd.trainings.idea.domain;

import org.jmolecules.ddd.annotation.ValueObject;

@ValueObject
public class IdeaNameVO {

  private final String nameValue;

  public IdeaNameVO(String nameValue) {
    this.nameValue = nameValue;
  }

  public static IdeaNameVO from(String name) {
    if(name == null || name.length() < 10 || name.length() > 160) {
      throw new IllegalArgumentException("Name must be at least 10 characters long");
    } else {
      return new IdeaNameVO(name);
    }
  }

  public String getValue() {
    return nameValue;
  }
}
