package com.ddd.trainings;

import com.ddd.trainings.idea.api.app.TrainingIdeaService;
import com.ddd.trainings.idea.infra.TrainingIdeaRepo;
import com.ddd.trainings.infra.InMemoryReviewerRepo;
import com.ddd.trainings.infra.InMemoryTrainingIdeaRepo;
import com.ddd.trainings.infra.InMemoryTrainingProposalRepo;
import com.ddd.trainings.proposal.domain.ReviewerPolicyFactory;
import com.ddd.trainings.proposal.infra.ReviewerRepo;
import com.ddd.trainings.proposal.infra.TrainingProposalRepo;
import org.junit.jupiter.api.BeforeEach;

public class TrainingTests {


  protected TrainingIdeaService service;
  protected TrainingIdeaRepo ideaRepo;
  protected TrainingProposalRepo proposalRepo;
  protected ReviewerRepo reviewerRepo;

  @BeforeEach
  void setUp() {
    ideaRepo = new InMemoryTrainingIdeaRepo();
    proposalRepo = new InMemoryTrainingProposalRepo();
    reviewerRepo = new InMemoryReviewerRepo();

    service = new TrainingIdeaService(ideaRepo, proposalRepo, new ReviewerPolicyFactory(reviewerRepo));

  }
}
