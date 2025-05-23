package com.ddd.trainings.proposal.infra;

import com.ddd.trainings.proposal.domain.ProposalId;
import com.ddd.trainings.proposal.domain.TrainingProposal;
import com.ddd.utils.BaseRepo;

public interface TrainingProposalRepo
    extends BaseRepo<TrainingProposal, ProposalId> {

}
