package com.ddd.trainings.domain;

import com.ddd.trainings.api.app.Error;
import com.ddd.utils.Result;
import org.jmolecules.ddd.annotation.Factory;

@Factory
public class TrainingIdeaFactory {

  public static Result<com.ddd.trainings.api.app.Error, TrainingIdea> create(String trainerId, String name) {
    Result<Error, IdeaNameVO> ideaNameResult = IdeaNameVO.from(name);
    if (ideaNameResult.isError()) {
      return Result.error(ideaNameResult.getError());
    }
    IdeaId ideaId = IdeaId.create();
    TrainerId trainerIdVO = TrainerId.from(trainerId);
    TrainingIdea idea = new TrainingIdea(ideaId, trainerIdVO, ideaNameResult.getSuccess());
    return Result.success(idea);
  }
}
