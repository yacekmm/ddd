using Ddd.Trainings.Idea.Domain;

namespace Ddd.Trainings.Proposal.Domain;

public class ByKeywordsReviewerPolicy : ReviewerPolicy
{
    private readonly IReviewerRepo _reviewerRepo;
    private readonly IdeaNameVO _name;

    public ByKeywordsReviewerPolicy(IReviewerRepo reviewerRepo, IdeaNameVO name)
    {
        _reviewerRepo = reviewerRepo;
        _name = name;
    }

    public ReviewerId SelectReviewer()
    {
        var candidates = _reviewerRepo.FindByKeywordsOrderByCurrentReviewsCount(_name.Keywords);
        return candidates.Select(r => r.Id).FirstOrDefault() ?? throw new Exception("No available reviewers");
    }
} 