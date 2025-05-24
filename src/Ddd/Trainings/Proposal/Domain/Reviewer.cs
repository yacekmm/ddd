using Ddd.Utils;

namespace Ddd.Trainings.Proposal.Domain;

public class Reviewer : BaseEntity<ReviewerId>
{
    public ReviewerId Id { get; }
    public string Name { get; }
    public string[] Keywords { get; }
    public int CurrentReviewsCount { get; private set; }

    public Reviewer(ReviewerId id, string name, string[] keywords)
    {
        Id = id;
        Name = name;
        Keywords = keywords;
        CurrentReviewsCount = 0;
    }

    public override ReviewerId GetId()
    {
        return Id;
    }

    public void IncrementReviewsCount()
    {
        CurrentReviewsCount++;
    }
} 