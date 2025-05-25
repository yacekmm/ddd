package com.ddd.trainings.api.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.ddd.trainings.TrainingTests;
import com.ddd.trainings.idea.domain.IdeaId;
import com.ddd.trainings.proposal.domain.Reviewer;
import com.ddd.trainings.proposal.domain.ReviewerFactory;
import org.junit.jupiter.api.Test;

class TrainingIdeaService_propose_test extends TrainingTests {

  @Test
  void proposeIdea_createsProposal_onValid() {
    //given
    IdeaId ideaId = trainingIdeaBuilder.inDb().getId();
    Reviewer expectedReviewer = reviewerRepo.save(ReviewerFactory.create());

    //when
    service.proposeIdea(ideaId.getValue());

    //then
    assertEquals(1, proposalRepo.count());
    //TODO: Expect reviewer to be selected
  }

  @Test
  void proposeIdea_error_onMissingReviewers() {
    //given
    IdeaId ideaId = trainingIdeaBuilder.inDb().getId();

    //expect
    // TODO: Assert exception on missing Reviewer
    assertEquals(0, proposalRepo.count());
  }
}