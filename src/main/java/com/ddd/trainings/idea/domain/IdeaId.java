package com.ddd.trainings.idea.domain;

import static java.util.UUID.randomUUID;

import com.ddd.utils.BaseId;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode(of = "value", callSuper = false)
public class IdeaId extends BaseId {

  @Getter
  private final String value;

  public IdeaId(String value) {
    this.value = value;
  }

  public static IdeaId create() {
    return new IdeaId(randomUUID().toString());
  }

  public static IdeaId from(String ideaId) {
    return new IdeaId(ideaId);
  }
}
