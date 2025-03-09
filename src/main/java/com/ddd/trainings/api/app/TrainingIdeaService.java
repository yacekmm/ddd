package com.ddd.trainings.api.app;

import com.ddd.trainings.domain.IdeaId;
import com.ddd.trainings.domain.IdeaNameVO;
import com.ddd.trainings.domain.TrainerId;
import com.ddd.trainings.domain.TrainingIdea;
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
    Result<Error, IdeaNameVO> ideaNameResult = IdeaNameVO.from(name);
    if(ideaNameResult.isError()) {
      return Result.error(ideaNameResult.getError());
    }
    IdeaId ideaId = IdeaId.create();
    TrainerId trainerIdVO = TrainerId.from(trainerId);
    TrainingIdea idea = new TrainingIdea(ideaId, trainerIdVO, ideaNameResult.getSuccess());
    repository.save(idea);
    return Result.success(idea.getId());
  }
}
