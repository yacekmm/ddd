using System.Collections.Generic;
using Ddd.Trainings.Proposal.Domain;
using Ddd.Utils;

namespace Ddd.Trainings.Proposal.Domain.Ports;

public interface ITrainingProposalRepo
{
    TrainingProposal Save(TrainingProposal proposal);
    List<TrainingProposal> FindAll();
    TrainingProposal? FindById(ProposalId proposalId);
} 