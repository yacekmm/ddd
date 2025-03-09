package com.ddd.trainings.api.app;

import com.ddd.trainings.domain.TrainingIdea;
import com.ddd.trainings.infra.TrainingIdeaRepository;
import java.util.UUID;
import org.jmolecules.ddd.annotation.Service;

@Service
public class TrainingIdeaService {
  
  private final TrainingIdeaRepository repository;
  
  public TrainingIdeaService(TrainingIdeaRepository repository) {
    this.repository = repository;
  }

  public UUID createTrainingIdea(UUID trainerId, String name) {
    TrainingIdea idea = new TrainingIdea(UUID.randomUUID(), trainerId, name);
    return repository.save(idea).getId();
  }
}
