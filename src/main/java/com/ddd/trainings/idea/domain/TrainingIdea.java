package com.ddd.trainings.idea.domain;

import com.ddd.trainings.proposal.domain.ReviewerPolicy;
import com.ddd.trainings.proposal.domain.TrainingProposal;
import com.ddd.trainings.proposal.domain.TrainingProposalFactory;
import com.ddd.utils.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.jmolecules.ddd.annotation.Entity;

@Entity
@AllArgsConstructor
@Getter
public class TrainingIdea extends BaseEntity {
  
  private final IdeaId ideaId;
  private final TrainerId trainerId;
  private final IdeaNameVO name;
  private final TrainingDurationVO duration;

  @Override
  public IdeaId getId() {
    return ideaId;
  }

  public TrainingProposal propose(ReviewerPolicy reviewerPolicy) {
    return TrainingProposalFactory.from(getId(), reviewerPolicy.selectReviewer());
  }
}
