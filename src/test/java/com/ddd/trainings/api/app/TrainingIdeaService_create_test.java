package com.ddd.trainings.api.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.ddd.trainings.TrainingTests;
import org.junit.jupiter.api.Test;

class TrainingIdeaService_create_test extends TrainingTests {


  @Test
  void createIdea_persistsIdea_onValidInputs() {
    //when
    service.createTrainingIdea("trainer-id", "DDD Training");

    //then
    assertEquals(1, ideaRepo.findAll().size());
  }

  @Test
  void createIdea_error_onInvalidTitle() {
    //expect
    // TODO: test name validation (In Service?)
  }
}