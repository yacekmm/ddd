package com.ddd.trainings.api.app;

import com.ddd.trainings.TrainingTests;
import org.junit.jupiter.api.Test;

class TrainingIdeaService_create_test extends TrainingTests {


  @Test
  void createIdea_persistsIdea_onValidInputs() {
    //when
    service.createTrainingIdea("trainer-id", "DDD Training");

    //then
    // TODO: Assert idea is persisted in repository
  }

  @Test
  void createIdea_error_onInvalidTitle() {
    // TODO: Assert that error is returned.
    // TODO: Assert idea is not persisted
  }
}