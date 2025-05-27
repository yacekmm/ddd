using Xunit;
using Ddd.Trainings.Idea.Domain;
using Ddd.Trainings.Proposal.Domain;
using Ddd.Tests.Trainings.Tests;

namespace Ddd.Tests.Trainings.Idea.App;

public class TrainingIdeaService_propose_test : TrainingTests
{
  [Fact]
  public void ProposeIdea_createsProposal_onValid()
  {
    //given
    var ideaId = TrainingIdeaBuilder.WithName("Test Idea long enough").InDb().IdeaId;
    ReviewerRepo.Save(ReviewerFactory.Create("name", ["idea"]));

    //when
    Service.ProposeIdea(ideaId.GetValue());

    //then
    // TODO: Test if proposal was created and persisted
  }

  [Fact]
  public void ProposeIdea_error_onMissingReviewers()
  {
    //given
    var ideaId = TrainingIdeaBuilder.InDb().IdeaId;

    //expect
    // not yet...
  }
}