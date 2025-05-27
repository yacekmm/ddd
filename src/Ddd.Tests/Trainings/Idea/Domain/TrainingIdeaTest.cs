using Ddd.Tests.Trainings.Tests;
using Ddd.Trainings.Idea.Domain;
using Ddd.Trainings.Proposal.Domain;
using Xunit;

namespace Ddd.Trainings.Idea.Domain;

public class TrainingIdeaTest : TrainingTests
{
    [Fact]
    public void EditDuration_UpdatesDuration()
    {
        // given
        TrainingIdea idea = TrainingIdeaBuilder.Build();

        // when
        idea.EditDuration(TrainingDurationVO.From(3));

        // then
        Assert.Equal(3, idea.Duration.Days);
    }

    [Fact]
    public void EditDuration_ThrowsException_WhenIdeaIsProposed()
    {
        // given
        TrainingIdea idea = TrainingIdeaBuilder.Proposed(true).Build();

        // when & then
        // not yet...
    }

    [Fact]
    public void Propose_CreatesProposal_WhenDurationIsValid()
    {
        // given
        TrainingIdea idea = TrainingIdeaBuilder.Build();

        // when
        TrainingProposal proposal = idea.Propose(FakeReviewerPolicy);

        // then
        // TODO: Implement tests validating if idea was proposed correctly
    }

    [Fact]
    public void Propose_ThrowsException_WhenDurationIsEmpty()
    {
        // given
        TrainingIdea idea = TrainingIdeaBuilder
            .WithDuration(TrainingDurationVO.Empty())
            .Build();

        // expect
        // TODO: Validate if exception is thrown
        // var exception = Assert.Throws<ArgumentException>(() => idea.Propose(FakeReviewerPolicy));
    }
} 