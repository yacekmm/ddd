package com.ddd.trainings.proposal.domain.events;

import com.ddd.trainings.idea.domain.IdeaId;
import com.ddd.trainings.proposal.domain.ProposalId;
import com.ddd.trainings.proposal.domain.ReviewerId;

public record ProposalCreatedEvent(ProposalId id, IdeaId ideaId, ReviewerId reviewerId) {

}
