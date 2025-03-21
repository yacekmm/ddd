package com.ddd.trainings.proposal.domain;

import com.ddd.trainings.idea.domain.IdeaId;
import com.ddd.utils.BaseEntity;
import lombok.Getter;

public class TrainingTemplate extends BaseEntity {

  @Getter
  private final TemplateId id;
  private final IdeaId ideaId;
  @Getter
  private final String review;

  public TrainingTemplate(TemplateId id, IdeaId ideaId, String review) {
    this.id = id;
    this.ideaId = ideaId;
    this.review = review;
  }

  @Override
  public TemplateId getId() {
    return id;
  }
} 