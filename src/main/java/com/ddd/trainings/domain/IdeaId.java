package com.ddd.trainings.domain;

import static java.util.UUID.randomUUID;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(of = "value")
public class IdeaId {

  private final String value;

  public IdeaId(String value) {
    this.value = value;
  }

  public static IdeaId create() {
    return new IdeaId(randomUUID().toString());
  }


}
