package com.ddd.trainings.idea.api.app;

import com.ddd.trainings.idea.domain.IdeaId;
import com.ddd.trainings.idea.domain.TrainingIdea;
import com.ddd.trainings.idea.domain.TrainingIdeaFactory;
import com.ddd.trainings.idea.infra.TrainingIdeaRepo;
import com.ddd.trainings.proposal.domain.ProposalId;
import com.ddd.trainings.proposal.domain.ReviewerPolicyFactory;
import com.ddd.trainings.proposal.domain.TrainingProposal;
import com.ddd.trainings.proposal.infra.TrainingProposalRepo;
import org.jmolecules.ddd.annotation.Service;

@Service
public class TrainingIdeaService {

  private final TrainingIdeaRepo ideaRepo;
  private final TrainingProposalRepo proposalRepo;

  public TrainingIdeaService(TrainingIdeaRepo ideaRepo, TrainingProposalRepo proposalRepo) {
    this.ideaRepo = ideaRepo;
    this.proposalRepo = proposalRepo;
  }

  public IdeaId createTrainingIdea(String trainerId, String name) {
    TrainingIdea idea = TrainingIdeaFactory.create(trainerId, name);
    TrainingIdea saved = ideaRepo.save(idea);
    return saved.getId();
  }

  public ProposalId proposeIdea(String ideaId) {
    TrainingIdea idea = ideaRepo.findById(IdeaId.from(ideaId))
        .orElseThrow(() -> new RuntimeException("Idea not found"));

    TrainingProposal proposal = idea.propose(reviewerPolicyFactory.byKeywords(idea.getName()));
    proposalRepo.save(proposal);
    return proposal.getId();
  }
}
