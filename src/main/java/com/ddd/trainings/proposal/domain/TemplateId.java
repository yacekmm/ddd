package com.ddd.trainings.proposal.domain;

import com.ddd.utils.BaseId;
import java.util.UUID;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode(of = "value", callSuper = false)
public class TemplateId extends BaseId {

  @Getter
  private final String value;

  public TemplateId(String value) {
    this.value = value;
  }

  public static TemplateId create() {
    return new TemplateId(UUID.randomUUID().toString());
  }
} 