using Ddd.Trainings.Idea.Domain;
using Ddd.Trainings.Proposal.Domain;

namespace Ddd.Trainings.Proposal.Domain.Events;

public record ProposalCreatedEvent(ProposalId Id, IdeaId IdeaId, ReviewerId ReviewerId); 