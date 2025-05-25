using Xunit;
using Ddd.Trainings.Intro;

namespace Ddd.Tests.Trainings.Intro;

public class TrainingServiceTests
{
    private readonly TrainingService _trainingService;

    public TrainingServiceTests()
    {
        _trainingService = new TrainingService();
    }

    [Fact]
    public void CreatesValidTraining()
    {
        //TODO: Implement test validating if training can be created with valid name.
    }

    //TODO: Implement test checking that name validation returns error
} 