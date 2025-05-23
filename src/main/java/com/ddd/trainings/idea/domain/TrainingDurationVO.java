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
        //TODO: Implement validation of number of days
        return new TrainingDurationVO(days);
    }
} 