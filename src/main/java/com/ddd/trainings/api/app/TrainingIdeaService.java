package com.ddd.trainings.api.app;

import com.ddd.trainings.domain.IdeaId;
import com.ddd.trainings.domain.IdeaNameVO;
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

  public Result<Error, IdeaId> createTrainingIdea(UUID trainerId, String name) {
    Result<Error, IdeaNameVO> ideaNameResult = IdeaNameVO.from(name);
    if(ideaNameResult.isError()) {
      return Result.error(ideaNameResult.getError());
    }
    IdeaId ideaId = IdeaId.create();
    TrainingIdea idea = new TrainingIdea(ideaId, trainerId, ideaNameResult.getSuccess());
    repository.save(idea);
    return Result.success(idea.getId());
  }
}
