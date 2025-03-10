package com.ddd.trainings.infra;

import com.ddd.trainings.idea.domain.IdeaId;
import com.ddd.trainings.idea.domain.TrainingIdea;
import com.ddd.trainings.idea.infra.TrainingIdeaRepo;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class InMemoryTrainingIdeaRepo implements TrainingIdeaRepo {

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

  @Override
  public Optional<TrainingIdea> findById(IdeaId ideaId) {
    return database.values().stream()
        .filter(idea -> idea.getId().equals(ideaId))
        .findFirst();
  }
}
