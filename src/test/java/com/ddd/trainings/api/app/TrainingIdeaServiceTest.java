package com.ddd.trainings.api.app;

import static com.google.common.base.Strings.repeat;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import com.ddd.trainings.TrainingTests;
import com.ddd.trainings.infra.InMemoryTrainingIdeaRepository;
import com.ddd.trainings.infra.TrainingIdeaRepository;
import com.ddd.utils.Result;
import com.google.common.base.Strings;
import java.util.UUID;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TrainingIdeaServiceTest extends TrainingTests {

  private TrainingIdeaService service;
  private TrainingIdeaRepository repository;

  @BeforeEach
  void setUp() {
    repository = new InMemoryTrainingIdeaRepository();
    service = new TrainingIdeaService(repository);

  }

  @Test
  void createIdea_persistsIdea_onValidInputs() {
    //when
    service.createTrainingIdea(UUID.randomUUID(), "DDD Training");

    //then
    assertEquals(1, repository.findAll().size());
  }

  @Test
  void createIdea_error_onInvalidTitle() {
    //expect
    assertThat(service.createTrainingIdea(UUID.randomUUID(), null).isError()).isTrue();
    assertThat(service.createTrainingIdea(UUID.randomUUID(), "short").isError()).isTrue();
    assertThat(service.createTrainingIdea(UUID.randomUUID(), repeat("a", 161)).isError()).isTrue();

    assertThat(0).isEqualTo(repository.findAll().size());
  }
}