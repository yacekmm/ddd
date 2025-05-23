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
    // expect
    Assert.Throws<ArgumentException>(() => TrainingDurationVO.From(0));
    Assert.Throws<ArgumentException>(() => TrainingDurationVO.From(6));
    Assert.Throws<ArgumentException>(() => TrainingDurationVO.From(-1));
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