package com.ddd.trainings.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode(of = "value")
public class TrainerId {

  @Getter
  private final String value;

  private TrainerId(String value) {
    this.value = value;
  }

  public static TrainerId from(String value) {
    return new TrainerId(value);
  }
}
