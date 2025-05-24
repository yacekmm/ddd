using System.Collections.Generic;
using System.Linq;
using Ddd.Trainings.Proposal.Domain;
using Ddd.Trainings.Proposal.Domain.Ports;
using Ddd.Utils;

namespace Ddd.Tests.Trainings.Proposal.Infra.Tests;

public class InMemoryTrainingProposalRepo : BaseRepo<TrainingProposal, ProposalId>, ITrainingProposalRepo
{
    public override List<TrainingProposal> FindAll()
    {
        return base.FindAll().ToList();
    }
}