package com.ddd.trainings.api.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.ddd.trainings.TrainingTests;
import com.ddd.trainings.domain.IdeaId;
import org.junit.jupiter.api.Test;

class TrainingIdeaService_propose_test extends TrainingTests {

  @Test
  void proposeIdea_createsProposal_onValid() {
    //given
    IdeaId ideaId = service.createTrainingIdea("trainer-id", "DDD Training");

    //when
    service.proposeIdea(ideaId.getValue());

    //then
    assertEquals(1, proposalRepo.findAll().size());
  }
}