using Ddd.Trainings.Proposal.Domain.Ports;

namespace Ddd.Trainings.Proposal.Domain;

public class RandomReviewerPolicy(IReviewerRepo reviewerRepo) : IReviewerPolicy
{
  private readonly Random _random = new();

  public ReviewerId SelectReviewer()
    {
        var reviewers = reviewerRepo.FindAll().ToList();
        if (reviewers.Count == 0)
            throw new Exception("No available reviewers");
            
        var randomIndex = _random.Next(reviewers.Count);
        return reviewers[randomIndex].Id;
    }
} 