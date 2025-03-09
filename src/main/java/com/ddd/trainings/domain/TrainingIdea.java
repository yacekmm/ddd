package com.ddd.trainings.domain;

import org.jmolecules.ddd.annotation.Entity;

@Entity
public class TrainingIdea {

  private IdeaId ideaId;
  private TrainerId trainerId;
  private IdeaNameVO name;

  public TrainingIdea(IdeaId ideaId, TrainerId trainerId, IdeaNameVO name) {
    this.ideaId = ideaId;
    this.trainerId = trainerId;
    this.name = name;
  }

  public IdeaId getId() {
    return ideaId;
  }
}
