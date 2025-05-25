package com.ddd.trainings.proposal.domain;

import com.ddd.trainings.idea.domain.IdeaId;

public class TrainingProposalFactory {

    public static TrainingProposal from(IdeaId ideaId) {
        return new TrainingProposal(ProposalId.create(), ideaId, null, "");
    }
}
