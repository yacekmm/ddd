package com.ddd.trainings.api.app;

import com.ddd.trainings.TrainingTests;
import com.ddd.trainings.idea.domain.IdeaId;
import com.ddd.trainings.proposal.domain.ReviewerFactory;
import org.junit.jupiter.api.Test;

class TrainingIdeaService_propose_test extends TrainingTests {

  @Test
  void proposeIdea_createsProposal_onValid() {
    //given
    IdeaId ideaId = trainingIdeaBuilder.inDb().getId();
    reviewerRepo.save(ReviewerFactory.create());

    //when
    service.proposeIdea(ideaId.getValue());

    //then
    // later...
  }

  @Test
  void proposeIdea_error_onMissingReviewers() {
    //given
    IdeaId ideaId = trainingIdeaBuilder.inDb().getId();

    //expect
    // later...
  }
}