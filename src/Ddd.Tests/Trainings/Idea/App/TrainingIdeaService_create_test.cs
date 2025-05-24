using System;
using Xunit;
using Ddd.Tests.Trainings.Tests;
using Ddd.Trainings.Idea.Api.App;

namespace Ddd.Tests.Trainings.Idea.App;

public class TrainingIdeaService_create_test : TrainingTests
{
    private const string ValidTrainerId = "trainer-id";
    private const string ValidTitle = "DDD Training";
    private const string ShortTitle = "short";
    private static readonly string LongTitle = new('a', 161);

    [Fact]
    public void CreateIdea_persistsIdea_onValidInputs()
    {
        //when
        Service.CreateTrainingIdea(ValidTrainerId, ValidTitle);

        //then
        Assert.Single(IdeaRepo.FindAll());
        Assert.Equal(ValidTrainerId, IdeaRepo.FindAll().First().TrainerId.Value);
        Assert.Equal(ValidTitle, IdeaRepo.FindAll().First().Name.NameValue);
    }

    [Fact]
    public void CreateIdea_error_onInvalidTitle()
    {
        //expect
        Assert.Throws<ArgumentException>(() => Service.CreateTrainingIdea(ValidTrainerId, null!));
        Assert.Throws<ArgumentException>(() => Service.CreateTrainingIdea(ShortTitle, null!));
        Assert.Throws<ArgumentException>(() => Service.CreateTrainingIdea(LongTitle, null!));

        Assert.Empty(IdeaRepo.FindAll());
    }
} 