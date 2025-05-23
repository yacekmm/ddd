namespace Ddd.Trainings.Proposal.Domain;

public interface ReviewerPolicy
{
    ReviewerId SelectReviewer();
} 