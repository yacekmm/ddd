package com.ddd.trainings.idea.api.app;

import com.ddd.trainings.idea.domain.IdeaId;
import com.ddd.trainings.idea.domain.TrainingDurationVO;
import com.ddd.trainings.idea.domain.TrainingIdea;
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
  private final ReviewerPolicyFactory reviewerPolicyFactory;

  public TrainingIdeaService(TrainingIdeaRepo ideaRepo, TrainingProposalRepo proposalRepo, ReviewerPolicyFactory reviewerPolicyFactory) {
    this.ideaRepo = ideaRepo;
    this.proposalRepo = proposalRepo;
    this.reviewerPolicyFactory = reviewerPolicyFactory;
  }

  public IdeaId createTrainingIdea(String trainerId, String name) {
    // TODO: Implement creating idea using IdeaFactory
    // TODO: save it in the repository
    return null;
  }

  public ProposalId proposeIdea(String ideaId) {
    TrainingIdea idea = ideaRepo.findById(IdeaId.from(ideaId))
        .orElseThrow(() -> new RuntimeException("Idea not found"));

    TrainingProposal proposal = idea.propose(reviewerPolicyFactory.byKeywords(idea.getName()));
    proposalRepo.save(proposal);
    return proposal.getId();
  }

  public void editDuration(String ideaId, int days) {
    TrainingIdea idea = ideaRepo.findById(IdeaId.from(ideaId))
        .orElseThrow(() -> new RuntimeException("Idea not found"));
    idea.editDuration(TrainingDurationVO.from(days));
    ideaRepo.save(idea);
  }
}
