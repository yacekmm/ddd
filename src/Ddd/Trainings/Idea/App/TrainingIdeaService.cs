using Ddd.Trainings.Idea.Domain;
using Ddd.Trainings.Idea.Domain.Ports;
using Ddd.Trainings.Proposal.Domain;
using Ddd.Trainings.Proposal.Domain.Ports;

namespace Ddd.Trainings.Idea.Api.App;

public class TrainingIdeaService
{
    private readonly ITrainingIdeaRepo _ideaRepo;
    private readonly ITrainingProposalRepo _proposalRepo;
    private readonly ReviewerPolicyFactory _reviewerPolicyFactory;

    public TrainingIdeaService(
        ITrainingIdeaRepo ideaRepo,
        ITrainingProposalRepo proposalRepo,
        ReviewerPolicyFactory reviewerPolicyFactory)
    {
        _ideaRepo = ideaRepo;
        _proposalRepo = proposalRepo;
        _reviewerPolicyFactory = reviewerPolicyFactory;
    }

    public IdeaId CreateTrainingIdea(string trainerId, string name)
    {
        // TODO: Implement creating idea using IdeaFactory
        // TODO: save it in the repository
        return null;
    }

    public void EditDuration(string ideaId, int days)
    {
        TrainingIdea idea = _ideaRepo.FindById(IdeaId.From(ideaId)) ?? throw new Exception("Idea not found");
        idea.EditDuration(TrainingDurationVO.From(days));
        _ideaRepo.Save(idea);
    }

    public ProposalId ProposeIdea(string ideaId)
    {
        TrainingIdea idea = _ideaRepo.FindById(IdeaId.From(ideaId)) ?? throw new Exception("Idea not found");
        TrainingProposal proposal = idea.Propose(_reviewerPolicyFactory.ByKeywords(idea.Name));
        _proposalRepo.Save(proposal);
        return proposal.Id;
    }
}