package com.ddd.trainings.proposal.domain;

public class ReviewerFactory {

  public static Reviewer create() {
    return new Reviewer(ReviewerId.create());
  }
}
