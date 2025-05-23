using Ddd.Trainings.Idea.Domain;
using Ddd.Trainings.Idea.Infra;
using Ddd.Trainings.Proposal.Domain;
using Ddd.Trainings.Proposal.Infra;

namespace Ddd.Trainings.Idea.Api.App
{
    public class TrainingIdeaService(ITrainingIdeaRepo ideaRepo, TrainingProposalRepo proposalRepo, ReviewerPolicyFactory reviewerPolicyFactory)
  {
        private readonly ITrainingIdeaRepo _ideaRepo = ideaRepo;
        private readonly TrainingProposalRepo _proposalRepo = proposalRepo;
        private readonly ReviewerPolicyFactory _reviewerPolicyFactory = reviewerPolicyFactory;

    public IdeaId CreateTrainingIdea(string trainerId, string name)
        {
            TrainingIdea idea = TrainingIdeaFactory.Create(trainerId, name);
            TrainingIdea saved = _ideaRepo.Save(idea);
            return saved.GetId();
        }

        public ProposalId ProposeIdea(string ideaId)
        {
            TrainingIdea idea = _ideaRepo.FindById(IdeaId.From(ideaId)) ?? throw new Exception("Idea not found");
            TrainingProposal proposal = idea.Propose(_reviewerPolicyFactory.ByKeywords(idea.Name));
            _proposalRepo.Save(proposal);
            return proposal.Id;
        }
    }
} 