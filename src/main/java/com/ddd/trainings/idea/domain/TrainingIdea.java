package com.ddd.trainings.idea.domain;

import com.ddd.trainings.proposal.domain.ReviewerPolicy;
import com.ddd.trainings.proposal.domain.TrainingProposal;
import com.ddd.trainings.proposal.domain.TrainingProposalFactory;
import com.ddd.utils.BaseEntity;
import lombok.Getter;
import org.jmolecules.ddd.annotation.Entity;

@Entity
public class TrainingIdea extends BaseEntity {

  private IdeaId ideaId;
  private TrainerId trainerId;
  @Getter
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
