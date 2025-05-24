using Ddd.Trainings.Idea.Domain;

namespace Ddd.Trainings.Proposal.Domain
{
    public static class TrainingProposalFactory
    {
        public static TrainingProposal From(IdeaId ideaId, ReviewerId reviewerId)
        {
            return new TrainingProposal(ProposalId.Create(), ideaId, reviewerId, "");
        }
    }
} 