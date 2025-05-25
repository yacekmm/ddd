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
        var exception = Assert.Throws<InvalidOperationException>(() => idea.EditDuration(TrainingDurationVO.From(3)));
        Assert.Equal("Cannot edit duration of proposed idea", exception.Message);
    }

    [Fact]
    public void Propose_CreatesProposal_WhenDurationIsValid()
    {
        // given
        TrainingIdea idea = TrainingIdeaBuilder.Build();

        // when
        // TODO: Implement test that proposes training idea
    }

    [Fact]
    public void Propose_ThrowsException_WhenDurationIsEmpty()
    {
        // given
        TrainingIdea idea = TrainingIdeaBuilder
            .WithDuration(TrainingDurationVO.Empty())
            .Build();

        // when & then
        // TODO: verify that idea with invalidation throws exception
    }
} 