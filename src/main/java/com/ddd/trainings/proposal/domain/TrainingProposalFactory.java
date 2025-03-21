package com.ddd.trainings.proposal.domain;

import com.ddd.trainings.idea.domain.IdeaId;

public class TrainingProposalFactory {

    public static TrainingProposal from(IdeaId ideaId, ReviewerId reviewerId) {
        return new TrainingProposal(ProposalId.create(), ideaId, reviewerId, "");
    }
}
