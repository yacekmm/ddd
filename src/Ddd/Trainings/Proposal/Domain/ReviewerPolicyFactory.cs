using System;
using System.Linq;
using Ddd.Trainings.Idea.Domain;
using Ddd.Trainings.Proposal.Domain.Ports;

namespace Ddd.Trainings.Proposal.Domain
{
    public class ReviewerPolicyFactory
    {
        private readonly IReviewerRepo _reviewerRepo;
        private readonly Random _random = new Random();

        public ReviewerPolicyFactory(IReviewerRepo reviewerRepo)
        {
            _reviewerRepo = reviewerRepo;
        }

        public ReviewerPolicy ByKeywords(IdeaNameVO name)
        {
            return new ByKeywordsReviewerPolicy(_reviewerRepo, name);
        }

        public ReviewerPolicy Random()
        {
            return new RandomReviewerPolicy(_reviewerRepo);
        }
    }
} 