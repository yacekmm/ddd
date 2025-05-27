using System.Collections.Generic;
using Ddd.Trainings.Idea.Domain;
using Ddd.Trainings.Proposal.Domain.Events;
using Ddd.Utils;

namespace Ddd.Trainings.Proposal.Domain
{
    public class TrainingProposal : BaseEntity<ProposalId>
    {
        public ProposalId Id { get; }
        public IdeaId IdeaId { get; }
        public ReviewerId ReviewerId { get; }
        public ProposalStatus Status { get; private set; }
        private readonly List<object> _domainEvents = [];
        private readonly string _review;

        public TrainingProposal(ProposalId id, IdeaId ideaId, ReviewerId reviewerId, string review)
        {
            Id = id;
            IdeaId = ideaId;
            ReviewerId = reviewerId;
            _review = review;
            Status = ProposalStatus.Pending;
            _domainEvents.Add(new ProposalCreatedEvent(id, ideaId, reviewerId));
        }

        public TrainingTemplate Accept(string review)
        {
            return new TrainingTemplate(TemplateId.Create(), "Template from proposal", review, []);
        }

        public TrainingIdea Reject(string review)
        {
            // Implement
            return null!;
        }

        public List<object> GetDomainEvents()
        {
            return new List<object>(_domainEvents);
        }

        public void ClearDomainEvents()
        {
            _domainEvents.Clear();
        }

        public override ProposalId GetId()
        {
            return Id;
        }

        public void Accept()
        {
            if (Status != ProposalStatus.Pending)
                throw new InvalidOperationException("Can only accept pending proposals");
            Status = ProposalStatus.Accepted;
        }

        public void Reject()
        {
            if (Status != ProposalStatus.Pending)
                throw new InvalidOperationException("Can only reject pending proposals");
            Status = ProposalStatus.Rejected;
        }
    }
} 