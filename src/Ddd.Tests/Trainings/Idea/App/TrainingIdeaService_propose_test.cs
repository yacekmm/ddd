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
    var ideaId = TrainingIdeaBuilder.InDb().IdeaId;
    var expectedReviewer = ReviewerRepo.Save(ReviewerFactory.Create("name", ["keyword1", "keyword2"]));

    //when
    Service.ProposeIdea(ideaId.Value);

    //then
    Assert.Equal(1, ProposalRepo.Count());
    Assert.Equal(expectedReviewer.Id, ProposalRepo.FindAll().First().ReviewerId);
  }

  [Fact]
  public void ProposeIdea_error_onMissingReviewers()
  {
    //given
    var ideaId = TrainingIdeaBuilder.InDb().IdeaId;

    //expect
    Assert.Throws<Exception>(() => Service.ProposeIdea(ideaId.Value));
    Assert.Equal(0, ProposalRepo.Count());
  }
}