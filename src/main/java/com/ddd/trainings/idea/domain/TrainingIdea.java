package com.ddd.trainings.idea.domain;

import com.ddd.trainings.proposal.domain.ReviewerPolicy;
import com.ddd.trainings.proposal.domain.TrainingProposal;
import com.ddd.trainings.proposal.domain.TrainingProposalFactory;
import com.ddd.utils.BaseEntity;
import lombok.Getter;
import org.jmolecules.ddd.annotation.Entity;

@Entity
public class TrainingIdea extends BaseEntity {

  private final IdeaId ideaId;
  private final TrainerId trainerId;
  @Getter
  private final IdeaNameVO name;

  public TrainingIdea(IdeaId ideaId, TrainerId trainerId, IdeaNameVO name) {
    this.ideaId = ideaId;
    this.trainerId = trainerId;
    this.name = name;
  }

  public IdeaId getId() {
    return ideaId;
  }

  public TrainingProposal propose(ReviewerPolicy reviewerPolicy) {
    return TrainingProposalFactory.from(getId(), reviewerPolicy.selectReviewer());
  }
}
