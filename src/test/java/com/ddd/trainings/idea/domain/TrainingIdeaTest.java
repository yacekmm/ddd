package com.ddd.trainings.idea.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.ddd.trainings.TrainingTests;
import com.ddd.trainings.proposal.domain.TrainingProposal;
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
        TrainingProposal proposal = idea.propose(FAKE_REVIEWER_POLICY);

        // then
        // TODO: Implement tests validating if idea was proposed correctly
    }

    @Test
    void propose_throwsException_whenDurationIsEmpty() {
        // given
        TrainingIdea idea = trainingIdeaBuilder
            .withDuration(TrainingDurationVO.empty())
            .build();

        // when
//        var result = assertThatThrownBy(() -> idea.propose(FAKE_REVIEWER_POLICY));

        //then
        // TODO: Validate if exception is thrown
    }
} 