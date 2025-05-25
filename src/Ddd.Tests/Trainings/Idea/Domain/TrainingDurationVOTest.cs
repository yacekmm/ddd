using Ddd.Tests.Trainings.Tests;
using Ddd.Trainings.Idea.Domain;
using Xunit;

namespace Ddd.Tests.Trainings.Idea.Domain.Tests;

public class TrainingDurationVOTest : TrainingTests
{
  [Fact]
  public void From_CreatesTrainingDuration_OnValidDays()
  {
    // given
    int validDays = 3;

    // when
    TrainingDurationVO duration = TrainingDurationVO.From(validDays);

    // then
    Assert.NotNull(duration);
    Assert.Equal(validDays, duration.Days);
  }

  [Fact]
  public void From_ThrowsException_OnInvalidDays()
  {
    //TODO: implement test for number of days validation
  }

  [Fact]
  public void Empty_CreatesTrainingDuration_WithZeroDays()
  {
    // when
    TrainingDurationVO duration = TrainingDurationVO.Empty();

    // then
    Assert.NotNull(duration);
    Assert.Equal(0, duration.Days);
  }
}