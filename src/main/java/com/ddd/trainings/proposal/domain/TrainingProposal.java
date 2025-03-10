package com.ddd.trainings.proposal.domain;

import com.ddd.trainings.idea.domain.IdeaId;
import com.ddd.utils.BaseEntity;
import lombok.Getter;

public class TrainingProposal extends BaseEntity {

  @Getter
  private final ProposalId id;
  private final IdeaId ideaId;
  private String review;

  public TrainingProposal(ProposalId id, IdeaId ideaId, String review) {
    this.id = id;
    this.ideaId = ideaId;
    this.review = review;
  }
}
