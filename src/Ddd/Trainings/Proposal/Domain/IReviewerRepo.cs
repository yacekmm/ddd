using System.Collections.Generic;
using Ddd.Trainings.Idea.Domain;
using Ddd.Utils;

namespace Ddd.Trainings.Proposal.Domain;

public interface IReviewerRepo : IBaseRepo<Reviewer, ReviewerId>
{
    IEnumerable<Reviewer> FindByKeywordsOrderByCurrentReviewsCount(string[] keywords);
} 