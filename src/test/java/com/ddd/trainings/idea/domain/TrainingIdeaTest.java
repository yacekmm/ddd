package com.ddd.trainings.idea.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.ddd.trainings.TrainingTests;
import org.junit.jupiter.api.Test;

class TrainingIdeaTest extends TrainingTests {

    @Test
    void editDuration_updatesDuration() {
        // given
        TrainingIdea idea = trainingIdeaBuilder.build();

        // when
        idea.editDuration(TrainingDurationVO.from(3));

        // then
        assertThat(idea.getDuration().getDays()).isEqualTo(3);
    }

    @Test
    void editDuration_throwsException_whenIdeaIsProposed() {
        // given
        TrainingIdea idea = trainingIdeaBuilder.proposed(true).build();

        // when & then
        assertThatThrownBy(() -> idea.editDuration(TrainingDurationVO.from(3)))
            .isInstanceOf(IllegalStateException.class)
            .hasMessage("Cannot edit duration of proposed idea");
    }

    @Test
    void propose_createsProposal_whenDurationIsValid() {
        // given
        TrainingIdea idea = trainingIdeaBuilder.build();

        // when
        // TODO: Implement test that proposes training idea
    }

    @Test
    void propose_throwsException_whenDurationIsEmpty() {
        // given
        TrainingIdea idea = trainingIdeaBuilder
            .withDuration(TrainingDurationVO.empty())
            .build();

        // when & then
        // TODO: verify that idea with invalidation throws exception
    }
} 