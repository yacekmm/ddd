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
        // TODO: Assert idea is persisted in repository
    }

    [Fact]
    public void CreateIdea_error_onInvalidTitle()
    {
        // TODO: Assert that error is returned.
        // TODO: Assert idea is not persisted
    }
} 