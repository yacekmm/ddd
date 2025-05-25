package com.ddd.trainings.idea.domain;

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
  
  private IdeaId ideaId;
  private TrainerId trainerId;
  private IdeaNameVO name;
  private TrainingDurationVO duration;
  private boolean isProposed;

  @Override
  public IdeaId getId() {
    return ideaId;
  }

  public void editDuration(TrainingDurationVO duration) {
    if (isProposed) {
      throw new IllegalStateException("Cannot edit duration of proposed idea");
    }
    this.duration = duration;
  }

  public TrainingProposal propose() {
    if(duration.isEmpty()) {
      throw new IllegalArgumentException("Duration is empty");
    }
    isProposed = true;
    // TODO: Use Select Reviewer Policy
    return TrainingProposalFactory.from(this.getId());
  }
}
