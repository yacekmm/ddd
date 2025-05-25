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
            // TODO: Move it to IdeaValidationService.validateEdit Domain Service. make sure it is properly tested
            Duration = duration;
        }

        public TrainingProposal Propose(IReviewerPolicy reviewerPolicy)
        {
            // TODO: Move it to IdeaValidationService.validateProposal Domain Service. make sure it is properly tested
            IsProposed = true;
            return TrainingProposalFactory.From(GetId(), reviewerPolicy.SelectReviewer());
        }
    }
} 