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
        if (days < 1 || days > 5) {
            throw new IllegalArgumentException("Training duration must be between 1 and 5 days");
        }
        return new TrainingDurationVO(days);
    }
} 