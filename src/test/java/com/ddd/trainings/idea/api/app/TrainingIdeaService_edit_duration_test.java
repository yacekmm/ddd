package com.ddd.trainings.idea.api.app;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.ddd.trainings.TrainingTests;
import com.ddd.trainings.idea.domain.IdeaId;
import org.junit.jupiter.api.Test;

class TrainingIdeaService_edit_duration_test extends TrainingTests {

    @Test
    void editDuration_updatesDuration_onValidInput() {
        // given
        IdeaId ideaId = trainingIdeaBuilder.inDb().getId();

        // when
        service.editDuration(ideaId.getValue(), 3);

        // then
        var updatedIdea = ideaRepo.findById(ideaId).orElseThrow();
        assertThat(updatedIdea.getDuration().getDays()).isEqualTo(3);
    }

    @Test
    void editDuration_throwsException_whenIdeaNotFound() {
        // expect
        var exception = assertThrows(RuntimeException.class, 
            () -> service.editDuration("non-existent-id", 3));
        assertThat(exception.getMessage()).isEqualTo("Idea not found");
    }

    @Test
    void editDuration_throwsException_whenDurationInvalid() {
        // given
        IdeaId ideaId = trainingIdeaBuilder.inDb().getId();

        // expect
        assertThrows(IllegalArgumentException.class, 
            () -> service.editDuration(ideaId.getValue(), 0));
        assertThrows(IllegalArgumentException.class, 
            () -> service.editDuration(ideaId.getValue(), 6));
        assertThrows(IllegalArgumentException.class, 
            () -> service.editDuration(ideaId.getValue(), -1));
    }

    @Test
    void editDuration_throwsException_whenIdeaIsProposed() {
        // given
        var idea = trainingIdeaBuilder.proposed(true).inDb();
        var ideaId = idea.getId();

        // expect
        var exception = assertThrows(IllegalStateException.class, 
            () -> service.editDuration(ideaId.getValue(), 3));
        assertThat(exception.getMessage()).isEqualTo("Cannot edit duration of proposed idea");
    }
} 