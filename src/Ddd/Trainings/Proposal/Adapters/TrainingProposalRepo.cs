using Ddd.Trainings.Proposal.Domain;
using Ddd.Trainings.Proposal.Domain.Ports;
using Ddd.Utils;

namespace Ddd.Trainings.Proposal.Infra;

public class TrainingProposalRepo : BaseRepo<TrainingProposal, ProposalId>, ITrainingProposalRepo
{
  public override List<TrainingProposal> FindAll()
  {
    return base.FindAll().ToList();
  }
} 