package com.ddd.trainings.idea.infra;

import com.ddd.trainings.idea.domain.IdeaId;
import com.ddd.trainings.idea.domain.TrainingIdea;
import java.util.List;
import java.util.Optional;

public interface TrainingIdeaRepo {

  TrainingIdea save(TrainingIdea idea);

  List<TrainingIdea> findAll();

  Optional<TrainingIdea> findById(IdeaId ideaId);
}
