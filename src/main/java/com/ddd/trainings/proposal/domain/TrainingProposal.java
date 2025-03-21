package com.ddd.trainings.proposal.domain;

import com.ddd.trainings.idea.domain.IdeaId;
import com.ddd.trainings.idea.domain.TrainingIdea;
import com.ddd.utils.BaseEntity;
import lombok.Getter;

public class TrainingProposal extends BaseEntity {

  @Getter
  private final ProposalId id;
  private final IdeaId ideaId;
  @Getter
  private final ReviewerId reviewerId;
  private final String review;

  public TrainingProposal(ProposalId id, IdeaId ideaId, ReviewerId reviewerId, String review) {
    this.id = id;
    this.ideaId = ideaId;
    this.reviewerId = reviewerId;
    this.review = review;
  }

  public TrainingTemplate accept(String review) {
    return new TrainingTemplate(TemplateId.create(), ideaId, review);
  }

  public TrainingIdea reject(String review) {
    // TODO: Implement
    return null;
  }
}
