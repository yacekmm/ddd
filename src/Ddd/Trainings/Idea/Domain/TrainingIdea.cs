using Ddd.Trainings.Proposal.Domain;
using Ddd.Utils;

namespace Ddd.Trainings.Idea.Domain
{
    public class TrainingIdea(IdeaId ideaId, TrainerId trainerId, IdeaNameVO name, TrainingDurationVO duration) : BaseEntity<IdeaId>
    {
        public IdeaId IdeaId { get; } = ideaId;
        public TrainerId TrainerId { get; } = trainerId;
        public IdeaNameVO Name { get; } = name;
        public TrainingDurationVO Duration { get; private set; } = duration;
        public bool IsProposed { get; private set; } = false;

        public override IdeaId GetId()
        {
            return IdeaId;
        }

        public void EditDuration(TrainingDurationVO duration)
        {
            // TODO: Implement edit duration methods if idea is not yet proposed.
        }

        public TrainingProposal Propose(IReviewerPolicy reviewerPolicy)
        {
            if (Duration.IsEmpty())
            {
                throw new ArgumentException("Duration is empty");
            }
            IsProposed = true;
            return TrainingProposalFactory.From(GetId(), reviewerPolicy.SelectReviewer());
        }
    }
} 