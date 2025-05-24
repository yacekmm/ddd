using System.Collections.Generic;
using System.Linq;
using Ddd.Trainings.Proposal.Domain;
using Ddd.Utils;

namespace Ddd.Trainings.Proposal.Infra
{
    public class ReviewerRepo : BaseRepo<Reviewer, ReviewerId>
    {
        public IEnumerable<Reviewer> FindByKeywordsOrderByCurrentReviewsCount(string[] keywords)
        {
            return _entities.Values
                .Where(r => r.Keywords.Intersect(keywords, StringComparer.OrdinalIgnoreCase).Any())
                .OrderBy(r => r.CurrentReviewsCount);
        }
    }
} 