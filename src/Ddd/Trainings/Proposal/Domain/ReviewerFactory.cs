namespace Ddd.Trainings.Proposal.Domain
{
    public static class ReviewerFactory
    {
        public static Reviewer Create(string name, string[] keywords)
        {
            return new Reviewer(ReviewerId.Create(), name, keywords);
        }
    }
} 