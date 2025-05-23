package com.ddd.trainings.idea.domain;

import com.ddd.trainings.idea.infra.TrainingIdeaRepo;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TrainingIdeaBuilder {
    private IdeaId ideaId = new IdeaId("test-id");
    private TrainerId trainerId = TrainerId.from("trainer-id");
    private IdeaNameVO name = IdeaNameVO.from("Test Training");
    private TrainingDurationVO duration = TrainingDurationVO.from(2);

    private final TrainingIdeaRepo ideaRepo;

    public TrainingIdeaBuilder withIdeaId(IdeaId ideaId) {
        this.ideaId = ideaId;
        return this;
    }

    public TrainingIdeaBuilder withTrainerId(TrainerId trainerId) {
        this.trainerId = trainerId;
        return this;
    }

    public TrainingIdeaBuilder withName(IdeaNameVO name) {
        this.name = name;
        return this;
    }

    public TrainingIdeaBuilder withDuration(TrainingDurationVO duration) {
        this.duration = duration;
        return this;
    }

    public TrainingIdea build() {
        return new TrainingIdea(ideaId, trainerId, name, duration);
    }

    public TrainingIdea inDb() {
        return ideaRepo.save(build());
    }
} 