using Ddd.Trainings.Idea.Domain;
using Ddd.Trainings.Proposal.Domain.Ports;

namespace Ddd.Trainings.Proposal.Domain
{
    public class ReviewerPolicyFactory(IReviewerRepo reviewerRepo)
  {
    public ReviewerPolicy ByKeywords(IdeaNameVO name)
        {
            return new ByKeywordsReviewerPolicy(reviewerRepo, name);
        }

        public ReviewerPolicy Random()
        {
            return new RandomReviewerPolicy(reviewerRepo);
        }
    }
} 