package com.ddd.trainings.idea.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.jmolecules.ddd.annotation.ValueObject;

@ValueObject
@AllArgsConstructor
public class TrainingDurationVO {
  
  @Getter
  private final int days;

  public static TrainingDurationVO from(int days) {
        //TODO: Implement validation of number of days (Value Object?)
        return new TrainingDurationVO(days);
    }

  public static TrainingDurationVO empty() {
    return new TrainingDurationVO(0);
  }

  public boolean isEmpty() {
    return days == 0;
  }
} 