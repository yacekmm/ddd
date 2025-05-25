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
            if (IsProposed)
            {
                throw new InvalidOperationException("Cannot edit duration of proposed idea");
            }
            Duration = duration;
        }

        public TrainingProposal Propose()
        {
            if (Duration.IsEmpty())
            {
                throw new ArgumentException("Duration is empty");
            }
            IsProposed = true;
            // TODO: Use Select Reviewer Policy
            return TrainingProposalFactory.From(GetId());
        }
    }
} 