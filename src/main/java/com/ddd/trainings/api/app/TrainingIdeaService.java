package com.ddd.trainings.api.app;

import com.ddd.trainings.domain.TrainingIdea;
import com.ddd.trainings.infra.TrainingIdeaRepository;
import com.ddd.utils.Result;
import java.util.UUID;
import org.jmolecules.ddd.annotation.Service;

@Service
public class TrainingIdeaService {
  
  private final TrainingIdeaRepository repository;
  
  public TrainingIdeaService(TrainingIdeaRepository repository) {
    this.repository = repository;
  }

  public Result<ErrorResult, UUID> createTrainingIdea(UUID trainerId, String name) {
    if(name == null || name.length() < 10 || name.length() > 160) {
      return Result.error("Name must be at least 10 characters long");
    }
    TrainingIdea idea = new TrainingIdea(UUID.randomUUID(), trainerId, name);
    repository.save(idea);
    return Result.success(idea.getId());
  }
}
