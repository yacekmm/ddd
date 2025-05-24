using Ddd.Trainings.Idea.Api.App;
using Ddd.Trainings.Idea.Domain.Tests;
using Ddd.Trainings.Idea.Domain.Ports;
using Ddd.Trainings.Proposal.Domain;
using Ddd.Trainings.Proposal.Domain.Ports;
using Ddd.Tests.Trainings.Idea.Infra.Tests;
using Ddd.Tests.Trainings.Proposal.Infra.Tests;

namespace Ddd.Tests.Trainings.Tests;

public abstract class TrainingTests
{
  protected TrainingIdeaService Service;
  protected ITrainingIdeaRepo IdeaRepo;
  protected ITrainingProposalRepo ProposalRepo;
  protected IReviewerRepo ReviewerRepo;
  protected TrainingIdeaBuilder TrainingIdeaBuilder;

  protected static readonly ReviewerPolicy FakeReviewerPolicy = new FakeReviewerPolicy();

  public TrainingTests()
  {
    IdeaRepo = new InMemoryTrainingIdeaRepo();
    ProposalRepo = new InMemoryTrainingProposalRepo();
    ReviewerRepo = new InMemoryReviewerRepo();
    Service = new TrainingIdeaService(IdeaRepo, ProposalRepo, new ReviewerPolicyFactory(ReviewerRepo));

    InitBuilders();
  }

  protected void InitBuilders()
  {
    TrainingIdeaBuilder = new TrainingIdeaBuilder(IdeaRepo);
  }
}

public class FakeReviewerPolicy : ReviewerPolicy
{
  public ReviewerId SelectReviewer()
  {
    return new ReviewerId("fake-reviewer-id");
  }
}