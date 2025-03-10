package com.ddd.trainings.infra;

import com.ddd.trainings.domain.IdeaId;
import com.ddd.trainings.domain.TrainingIdea;
import java.util.List;
import java.util.Optional;

public interface TrainingIdeaRepo {

  TrainingIdea save(TrainingIdea idea);

  List<TrainingIdea> findAll();

  Optional<TrainingIdea> findById(IdeaId ideaId);
}
