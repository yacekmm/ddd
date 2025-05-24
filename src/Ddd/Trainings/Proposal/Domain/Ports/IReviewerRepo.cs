using System.Collections.Generic;
using Ddd.Trainings.Proposal.Domain;
using Ddd.Utils;

namespace Ddd.Trainings.Proposal.Domain.Ports;

public interface IReviewerRepo : IBaseRepo<Reviewer, ReviewerId>
{
    IEnumerable<Reviewer> FindByKeywordsOrderByCurrentReviewsCount(string[] keywords);
} 