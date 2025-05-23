package com.ddd.exercise.intro;

import com.exercise.intro.TrainingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TrainingServiceTest {

  private TrainingService trainingService;

  @BeforeEach
  void setUp() {
    trainingService = new TrainingService();
  }


  @Test
  void createsValidTraining() {
    //TODO: Implement test validating if training can be created with valid title.
  }

  //TODO: Implement test checking that title validation returns error
}