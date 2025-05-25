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
    //TODO: Implement validation of idea name
    return new IdeaNameVO(name);
  }

  public String[] getKeywords() {
    return nameValue.split(" ");
  }
}
