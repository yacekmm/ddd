using Ddd.Tests.Trainings.Tests;
using Ddd.Trainings.Idea.Domain;
using Xunit;

namespace Ddd.Tests.Trainings.Idea.App;

public class TrainingIdeaService_edit_duration_test : TrainingTests
{
    [Fact]
    public void EditDuration_UpdatesDuration_OnValidInput()
    {
        // given
        var ideaId = TrainingIdeaBuilder.InDb().IdeaId;

        // when
        Service.EditDuration(ideaId.GetValue(), 3);

        // then
        var updatedIdea = IdeaRepo.FindById(ideaId);
        Assert.NotNull(updatedIdea);
        Assert.Equal(3, updatedIdea.Duration.Days);
    }

    [Fact]
    public void EditDuration_ThrowsException_WhenIdeaNotFound()
    {
        // expect
        var exception = Assert.Throws<Exception>(() => Service.EditDuration("non-existent-id", 3));
        Assert.Equal("Idea not found", exception.Message);
    }

    [Fact]
    public void EditDuration_ThrowsException_WhenDurationInvalid()
    {
        // given
        var ideaId = TrainingIdeaBuilder.InDb().GetId();

        // expect
        Assert.Throws<ArgumentException>(() => Service.EditDuration(ideaId.GetValue(), 0));
        Assert.Throws<ArgumentException>(() => Service.EditDuration(ideaId.GetValue(), 6));
        Assert.Throws<ArgumentException>(() => Service.EditDuration(ideaId.GetValue(), -1));
    }

    [Fact]
    public void EditDuration_ThrowsException_WhenIdeaIsProposed()
    {
        // given
        var idea = TrainingIdeaBuilder.Proposed(true).InDb();
        var ideaId = idea.GetId();

        // expect
        var exception = Assert.Throws<InvalidOperationException>(() => Service.EditDuration(ideaId.GetValue(), 3));
        Assert.Equal("Cannot edit duration of proposed idea", exception.Message);
    }
} 