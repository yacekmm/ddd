package com.ddd.trainings.proposal.domain;

import com.ddd.utils.BaseId;
import java.util.UUID;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class ReviewerId extends BaseId {

  @Getter
  private final String value;

  public ReviewerId(String value) {
    this.value = value;
  }

  public static ReviewerId create() {
    return new ReviewerId(UUID.randomUUID().toString());
  }
}