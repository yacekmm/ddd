package com.ddd.trainings.api.app;

import static org.junit.jupiter.api.Assertions.*;

import com.ddd.trainings.TrainingTests;
import com.ddd.trainings.infra.InMemoryTrainingIdeaRepository;
import com.ddd.trainings.infra.TrainingIdeaRepository;
import java.util.UUID;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TrainingIdeaServiceTest extends TrainingTests {

  @Test
  void createIdea_persistsIdea_onValidInputs() {
    //given
    TrainingIdeaRepository repository = new InMemoryTrainingIdeaRepository();
    TrainingIdeaService service = new TrainingIdeaService(repository);

    //when
    service.createTrainingIdea(UUID.randomUUID(), "DDD Training");

    //then
    assertEquals(1, repository.findAll().size());
  }
}