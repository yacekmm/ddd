package com.ddd.trainings.domain;

public class TrainingProposalFactory {

  public static TrainingProposal from(IdeaId ideaId) {
    return new TrainingProposal(ProposalId.create(), ideaId, null);
  }
}
