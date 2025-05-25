package com.ddd.trainings.idea.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.ddd.trainings.TrainingTests;
import com.ddd.trainings.proposal.domain.TrainingProposal;
import org.junit.jupiter.api.Test;

class TrainingIdeaTest extends TrainingTests {

    @Test
    void editDuration_updatesDuration() {
        //TODO Implement test for Edit Duration
    }

    @Test
    void editDuration_throwsException_whenIdeaIsProposed() {
        //TODO Test if edit duration throws exception when idea is already proposed.
    }

    @Test
    void propose_createsProposal_whenDurationIsValid() {
        // given
        TrainingIdea idea = trainingIdeaBuilder.build();

        // when
        TrainingProposal proposal = idea.propose(FAKE_REVIEWER_POLICY);

        // then
        assertThat(proposal).isNotNull();
        assertThat(proposal.getIdeaId()).isEqualTo(idea.getId());
        assertThat(idea.isProposed()).isTrue();
    }

    @Test
    void propose_throwsException_whenDurationIsEmpty() {
        // given
        TrainingIdea idea = trainingIdeaBuilder
            .withDuration(TrainingDurationVO.empty())
            .build();

        // when & then
        assertThatThrownBy(() -> idea.propose(FAKE_REVIEWER_POLICY))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("Duration is empty");
    }
} 