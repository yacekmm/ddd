package com.ddd.trainings.infra;

import com.ddd.trainings.domain.ProposalId;
import com.ddd.trainings.domain.TrainingProposal;
import com.ddd.utils.InMemoryRepo;

public class InMemoryTrainingProposalRepo
    extends InMemoryRepo<TrainingProposal, ProposalId>
    implements TrainingProposalRepo {

}
