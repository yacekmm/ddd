package com.ddd.trainings.idea.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.ddd.trainings.TrainingTests;
import org.junit.jupiter.api.Test;

class TrainingDurationVOTest extends TrainingTests {

    @Test
    void from_createsTrainingDuration_onValidDays() {
        // given
        int validDays = 3;

        // when
        TrainingDurationVO duration = TrainingDurationVO.from(validDays);

        // then
        assertThat(duration).isNotNull();
        assertThat(duration.getDays()).isEqualTo(validDays);
    }

    @Test
    void from_throwsException_onInvalidDays() {
        // expect
        assertThatThrownBy(() -> TrainingDurationVO.from(0)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> TrainingDurationVO.from(6)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> TrainingDurationVO.from(-1)).isInstanceOf(IllegalArgumentException.class);
    }
} 