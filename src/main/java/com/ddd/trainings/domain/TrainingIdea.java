package com.ddd.trainings.domain;

import java.util.UUID;
import org.jmolecules.ddd.annotation.Entity;

@Entity
public class TrainingIdea {

  private UUID ideaId;
  private UUID trainerId;
  private IdeaNameVO name;

  public TrainingIdea(UUID ideaId, UUID trainerId, IdeaNameVO name) {
    this.ideaId = ideaId;
    this.trainerId = trainerId;
    this.name = name;
  }

  public UUID getId() {
    return ideaId;
  }
}
