package com.ddd.trainings.api.app;

import static com.google.common.base.Strings.repeat;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    assertThrows(RuntimeException.class, () -> service.createTrainingIdea("trainer-id", null));
    assertThrows(RuntimeException.class, () -> service.createTrainingIdea("short", null));
    assertThrows(RuntimeException.class, () -> service.createTrainingIdea(repeat("a", 161), null));

    assertThat(0).isEqualTo(ideaRepo.findAll().size());
  }
}