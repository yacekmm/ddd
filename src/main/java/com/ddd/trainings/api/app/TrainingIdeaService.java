package com.ddd.trainings.api.app;

import com.ddd.trainings.domain.IdeaId;
import com.ddd.trainings.domain.TrainingIdea;
import com.ddd.trainings.domain.TrainingIdeaFactory;
import com.ddd.trainings.infra.TrainingIdeaRepository;
import com.ddd.utils.Result;
import org.jmolecules.ddd.annotation.Service;

@Service
public class TrainingIdeaService {
  
  private final TrainingIdeaRepository repository;
  
  public TrainingIdeaService(TrainingIdeaRepository repository) {
    this.repository = repository;
  }

  public Result<Error, IdeaId> createTrainingIdea(String trainerId, String name) {
    Result<Error, TrainingIdea> ideaResult = TrainingIdeaFactory.create(trainerId, name);
    if(ideaResult.isError()) {
      return Result.error(ideaResult.getError());
    }
    TrainingIdea saved = repository.save(ideaResult.getSuccess());
    return Result.success(saved.getId());
  }

}
