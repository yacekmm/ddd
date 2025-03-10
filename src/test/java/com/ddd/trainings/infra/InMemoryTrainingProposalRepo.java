package com.ddd.trainings.infra;

import com.ddd.trainings.proposal.domain.ProposalId;
import com.ddd.trainings.proposal.domain.TrainingProposal;
import com.ddd.trainings.proposal.infra.TrainingProposalRepo;
import com.ddd.utils.InMemoryRepo;

public class InMemoryTrainingProposalRepo
    extends InMemoryRepo<TrainingProposal, ProposalId>
    implements TrainingProposalRepo {

}
