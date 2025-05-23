package com.ddd.trainings.proposal.domain;

import com.ddd.trainings.idea.domain.IdeaId;
import com.ddd.trainings.idea.domain.TrainingIdea;
import com.ddd.trainings.proposal.domain.events.ProposalCreatedEvent;
import com.ddd.utils.BaseEntity;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

public class TrainingProposal extends BaseEntity {

  @Getter
  private final ProposalId id;
  private final IdeaId ideaId;
  @Getter
  private final ReviewerId reviewerId;
  private final List<Object> domainEvents = new ArrayList<>();
  private final String review;

  public TrainingProposal(ProposalId id, IdeaId ideaId, ReviewerId reviewerId, String review) {
    this.id = id;
    this.ideaId = ideaId;
    this.reviewerId = reviewerId;
    this.review = review;
    this.domainEvents.add(new ProposalCreatedEvent(id, ideaId, reviewerId));
  }

  public TrainingTemplate accept(String review) {
    return new TrainingTemplate(TemplateId.create(), ideaId, review);
  }

  public TrainingIdea reject(String review) {
    // TODO: Implement
    return null;
  }

  public List<Object> getDomainEvents() {
    return new ArrayList<>(domainEvents);
  }

  public void clearDomainEvents() {
    domainEvents.clear();
  }

  public TrainingTemplate accept(String review) {
    return new TrainingTemplate(TemplateId.create(), ideaId, review);
  }

  public TrainingIdea reject(String review) {
    // TODO: Implement
    return null;
  }
}
