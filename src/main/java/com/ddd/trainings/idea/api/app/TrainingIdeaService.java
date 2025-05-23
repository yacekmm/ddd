package com.ddd.trainings.idea.api.app;

import com.ddd.trainings.idea.domain.IdeaId;
import com.ddd.trainings.idea.domain.TrainingDurationVO;
import com.ddd.trainings.idea.domain.TrainingIdea;
import com.ddd.trainings.idea.domain.TrainingIdeaFactory;
import com.ddd.trainings.idea.infra.TrainingIdeaRepo;
import com.ddd.trainings.proposal.domain.ProposalId;
import com.ddd.trainings.proposal.domain.ReviewerPolicyFactory;
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
    TrainingIdea idea = TrainingIdeaFactory.create(trainerId, name);
    TrainingIdea saved = ideaRepo.save(idea);
    return saved.getId();
  }

  public ProposalId proposeIdea(String ideaId) {
    // TODO: Implement proposed methods Make sure to:
    // validate if duration is not empty
    // set flag isProposed to true
    // return new training proposal
    return null;
  }

  public void editDuration(String ideaId, int days) {
    TrainingIdea idea = ideaRepo.findById(IdeaId.from(ideaId))
        .orElseThrow(() -> new RuntimeException("Idea not found"));
    idea.editDuration(TrainingDurationVO.from(days));
    ideaRepo.save(idea);
  }
}
