package com.ddd.trainings.domain;

import com.ddd.utils.BaseEntity;
import org.jmolecules.ddd.annotation.Entity;

@Entity
public class TrainingIdea extends BaseEntity {

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

  public TrainingProposal propose() {
    return TrainingProposalFactory.from(getId());
  }
}
