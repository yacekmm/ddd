using System.Collections.Generic;
using System.Linq;
using Ddd.Trainings.Proposal.Domain;
using Ddd.Trainings.Proposal.Domain.Ports;
using Ddd.Utils;

namespace Ddd.Tests.Trainings.Proposal.Infra.Tests;

public class InMemoryReviewerRepo : BaseRepo<Reviewer, ReviewerId>, IReviewerRepo
{
    public override List<Reviewer> FindAll()
    {
        return base.FindAll().ToList();
    }

    public IEnumerable<Reviewer> FindByKeywordsOrderByCurrentReviewsCount(string[] keywords)
    {
        return FindAll();
    }
}