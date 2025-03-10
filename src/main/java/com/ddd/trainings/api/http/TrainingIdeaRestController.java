package com.ddd.trainings.api.http;

import com.ddd.trainings.api.app.TrainingIdeaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrainingIdeaRestController {

  private final TrainingIdeaService service;

  public TrainingIdeaRestController(TrainingIdeaService service) {
    this.service = service;
  }

  @PostMapping("/training/ideas")
  public void createTrainingIdea(String trainerId, String name) {
    service.createTrainingIdea(trainerId, name);
  }

  @PostMapping("/training/ideas/{ideaId}/propose")
  public void proposeTrainingIdea(String ideaId) {
    service.proposeIdea(ideaId);
  }
}
