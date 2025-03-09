package com.ddd.trainings.infra;

import com.ddd.trainings.domain.TrainingIdea;
import java.util.List;
import java.util.Map;

public interface TrainingIdeaRepository {

  TrainingIdea save(TrainingIdea idea);

  List<TrainingIdea> findAll();
}
