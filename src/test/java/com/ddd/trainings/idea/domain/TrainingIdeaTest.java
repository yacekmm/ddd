package com.ddd.trainings.idea.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.ddd.trainings.TrainingTests;
import com.ddd.trainings.proposal.domain.ReviewerId;
import com.ddd.trainings.proposal.domain.ReviewerPolicy;
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
    void propose_createsProposal_whenDurationIsValid() {
        // given
        TrainingIdea idea = trainingIdeaBuilder.build();
        ReviewerPolicy reviewerPolicy = () -> new ReviewerId("reviewer-id");

        // when
        TrainingProposal proposal = idea.propose(reviewerPolicy);

        // then
        assertThat(proposal).isNotNull();
        assertThat(proposal.getIdeaId()).isEqualTo(idea.getId());
    }

    @Test
    void propose_throwsException_whenDurationIsEmpty() {
        // given
        TrainingIdea idea = trainingIdeaBuilder
            .withDuration(TrainingDurationVO.empty())
            .build();
        ReviewerPolicy reviewerPolicy = () -> new ReviewerId("reviewer-id");

        // when & then
        assertThatThrownBy(() -> idea.propose(reviewerPolicy))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("Duration is empty");
    }
} 