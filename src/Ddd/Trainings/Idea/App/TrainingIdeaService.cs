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
        TrainingIdea idea = TrainingIdeaFactory.Create(trainerId, name);
        TrainingIdea saved = _ideaRepo.Save(idea);
        return saved.GetId();
    }

    public void EditDuration(string ideaId, int days)
    {
        TrainingIdea idea = _ideaRepo.FindById(IdeaId.From(ideaId)) ?? throw new Exception("Idea not found");
        idea.EditDuration(TrainingDurationVO.From(days));
        _ideaRepo.Save(idea);
    }

    public ProposalId ProposeIdea(string ideaId)
    {
        // TODO: Propose idea and persist updated entity
        return null;
    }
}