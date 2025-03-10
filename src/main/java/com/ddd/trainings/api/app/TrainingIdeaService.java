package com.ddd.trainings.api.app;

import com.ddd.trainings.domain.IdeaId;
import com.ddd.trainings.domain.ProposalId;
import com.ddd.trainings.domain.TrainingIdea;
import com.ddd.trainings.domain.TrainingIdeaFactory;
import com.ddd.trainings.domain.TrainingProposal;
import com.ddd.trainings.infra.TrainingIdeaRepo;
import com.ddd.trainings.infra.TrainingProposalRepo;
import java.util.Optional;
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
    Optional<TrainingIdea> idea = ideaRepo.findById(IdeaId.from(ideaId));
    if(idea.isPresent()) {
      TrainingProposal proposal = idea.get().propose();
      proposalRepo.save(proposal);
      return proposal.getId();
    } else {
      throw new RuntimeException("Idea not found");

    }
  }
}
