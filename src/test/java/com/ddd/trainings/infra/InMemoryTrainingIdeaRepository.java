package com.ddd.trainings.infra;

import com.ddd.trainings.domain.IdeaId;
import com.ddd.trainings.domain.TrainingIdea;
import java.util.HashMap;
import java.util.List;

public class InMemoryTrainingIdeaRepository implements TrainingIdeaRepository {

  private final HashMap<IdeaId, TrainingIdea> database = new HashMap<>();

  @Override
  public TrainingIdea save(TrainingIdea idea) {
    database.put(idea.getId(), idea);
    return idea;
  }

  @Override
  public List<TrainingIdea> findAll() {
    return database.values().stream().toList();
  }
}
