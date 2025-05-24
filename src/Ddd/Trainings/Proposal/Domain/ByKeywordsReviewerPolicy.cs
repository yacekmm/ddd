using Ddd.Trainings.Idea.Domain;
using Ddd.Trainings.Proposal.Domain.Ports;

namespace Ddd.Trainings.Proposal.Domain;

public class ByKeywordsReviewerPolicy(IReviewerRepo reviewerRepo, IdeaNameVO name) : IReviewerPolicy
{
  public ReviewerId SelectReviewer()
    {
        var candidates = reviewerRepo.FindByKeywordsOrderByCurrentReviewsCount(name.Keywords);
        return candidates.Select(r => r.Id).FirstOrDefault() ?? throw new Exception("No available reviewers");
    }
} 