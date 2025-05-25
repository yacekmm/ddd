using Ddd.Trainings.Idea.Domain;
using Ddd.Trainings.Proposal.Domain.Ports;

namespace Ddd.Trainings.Proposal.Domain
{
    public class ReviewerPolicyFactory(IReviewerRepo reviewerRepo)
  {
    public IReviewerPolicy ByKeywords(IdeaNameVO name)
        {
            return new ByKeywordsReviewerPolicy(reviewerRepo, name);
        }

        public IReviewerPolicy Random()
        {
            return new RandomReviewerPolicy(reviewerRepo);
        }

        // TODO: implement new policy and test for it
    }
} 