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
        //TODO Implement test for Edit Duration
    }

    [Fact]
    public void EditDuration_ThrowsException_WhenIdeaIsProposed()
    {
        //TODO Test if edit duration throws exception when idea is already proposed.
    }

    [Fact]
    public void Propose_CreatesProposal_WhenDurationIsValid()
    {
        // given
        TrainingIdea idea = TrainingIdeaBuilder.Build();

        // when
        TrainingProposal proposal = idea.Propose(FakeReviewerPolicy);

        // then
        Assert.NotNull(proposal);
        Assert.Equal(idea.GetId(), proposal.IdeaId);
        Assert.True(idea.IsProposed);
    }

    [Fact]
    public void Propose_ThrowsException_WhenDurationIsEmpty()
    {
        // given
        TrainingIdea idea = TrainingIdeaBuilder
            .WithDuration(TrainingDurationVO.Empty())
            .Build();

        // when & then
        var exception = Assert.Throws<ArgumentException>(() => idea.Propose(FakeReviewerPolicy));
        Assert.Equal("Duration is empty", exception.Message);
    }
} 