package com.ddd.trainings.domain;

import java.util.UUID;
import org.jmolecules.ddd.annotation.Entity;

@Entity
public class TrainingIdea {

  private UUID ideaId;
  private UUID trainerId;
  private String name;

  public TrainingIdea(UUID ideaId, UUID trainerId, String name) {
    this.ideaId = ideaId;
    this.trainerId = trainerId;
    this.name = name;
  }

  public UUID getId() {
    return ideaId;
  }
}
