using System.Collections.Generic;
using System.Linq;
using Ddd.Trainings.Proposal.Domain;
using Ddd.Trainings.Proposal.Infra;
using Ddd.Utils;

namespace Ddd.Tests.Trainings.Proposal.Infra.Tests;

public class InMemoryReviewerRepo : BaseRepo<Reviewer, ReviewerId>, IReviewerRepo
{
  public IEnumerable<Reviewer> FindByKeywordsOrderByCurrentReviewsCount(string[] value)
  {
    return _entities.Values.ToList();
  }
}