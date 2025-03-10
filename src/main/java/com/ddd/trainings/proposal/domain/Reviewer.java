package com.ddd.trainings.proposal.domain;

import com.ddd.utils.BaseEntity;
import lombok.Getter;

public class Reviewer extends BaseEntity {

  @Getter
  private final ReviewerId id;

  public Reviewer(ReviewerId id) {
    this.id = id;
  }
}
