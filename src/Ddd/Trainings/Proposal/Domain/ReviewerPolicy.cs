
namespace Ddd.Trainings.Proposal.Domain;

public interface IReviewerPolicy
{
    ReviewerId SelectReviewer();
} 