package com.ddd.trainings.idea.domain;

import static org.assertj.core.api.Assertions.assertThat;

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
        //TODO: implement test for number of days validation
    }

    @Test
    void empty_createsTrainingDuration_withZeroDays() {
        // when
        TrainingDurationVO duration = TrainingDurationVO.empty();

        // then
        assertThat(duration).isNotNull();
        assertThat(duration.getDays()).isZero();
    }

} 