using Ddd.Trainings.Idea.Domain.Ports;
using Ddd.Trainings.Proposal.Domain;

namespace Ddd.Trainings.Idea.Domain.Tests;

public class TrainingIdeaBuilder
{
    private IdeaId _ideaId = new IdeaId("test-id");
    private TrainerId _trainerId = TrainerId.From("trainer-id");
    private IdeaNameVO _name = IdeaNameVO.From("Test Training");
    private TrainingDurationVO _duration = TrainingDurationVO.From(2);
    private bool _isProposed;

    private readonly ITrainingIdeaRepo _ideaRepo;

    public TrainingIdeaBuilder(ITrainingIdeaRepo ideaRepo)
    {
        _ideaRepo = ideaRepo;
    }

    public TrainingIdeaBuilder WithIdeaId(IdeaId ideaId)
    {
        _ideaId = ideaId;
        return this;
    }

    public TrainingIdeaBuilder WithTrainerId(TrainerId trainerId)
    {
        _trainerId = trainerId;
        return this;
    }

    public TrainingIdeaBuilder WithName(string name)
    {
        _name = IdeaNameVO.From(name);
        return this;
    }

    public TrainingIdeaBuilder WithDuration(TrainingDurationVO duration)
    {
        _duration = duration;
        return this;
    }

    public TrainingIdeaBuilder Proposed(bool isProposed)
    {
        _isProposed = isProposed;
        return this;
    }

    public TrainingIdea Build()
    {
        var idea = new TrainingIdea(_ideaId, _trainerId, _name, _duration);
        if (_isProposed)
        {
            idea.Propose(new FakeReviewerPolicy());
        }
        return idea;
    }

    public TrainingIdea InDb()
    {
        return _ideaRepo.Save(Build());
    }

    private class FakeReviewerPolicy : IReviewerPolicy
    {
        public ReviewerId SelectReviewer()
        {
            return new ReviewerId("fake-reviewer-id");
        }
    }
} 