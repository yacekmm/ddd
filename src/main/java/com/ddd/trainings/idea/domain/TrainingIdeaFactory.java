package com.ddd.trainings.idea.domain;

import org.jmolecules.ddd.annotation.Factory;

@Factory
public class TrainingIdeaFactory {

  public static TrainingIdea create(String trainerId, String name) {
    IdeaNameVO ideaName = IdeaNameVO.from(name);
    IdeaId ideaId = IdeaId.create();
    TrainerId trainerIdVO = TrainerId.from(trainerId);
    TrainingIdea idea = new TrainingIdea(ideaId, trainerIdVO, ideaName);
    return idea;
  }
}
