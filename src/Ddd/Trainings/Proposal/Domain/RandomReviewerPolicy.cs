using Ddd.Trainings.Proposal.Domain.Ports;

namespace Ddd.Trainings.Proposal.Domain;

public class RandomReviewerPolicy : ReviewerPolicy
{
    private readonly IReviewerRepo _reviewerRepo;
    private readonly Random _random;

    public RandomReviewerPolicy(IReviewerRepo reviewerRepo)
    {
        _reviewerRepo = reviewerRepo;
        _random = new Random();
    }

    public ReviewerId SelectReviewer()
    {
        var reviewers = _reviewerRepo.FindByKeywordsOrderByCurrentReviewsCount(Array.Empty<string>()).ToList();
        if (!reviewers.Any())
            throw new Exception("No available reviewers");
            
        var randomIndex = _random.Next(reviewers.Count);
        return reviewers[randomIndex].Id;
    }
} 