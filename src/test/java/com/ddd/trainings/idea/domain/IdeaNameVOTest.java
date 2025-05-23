package com.ddd.trainings.idea.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.ddd.trainings.TrainingTests;
import org.junit.jupiter.api.Test;

class IdeaNameVOTest extends TrainingTests {

    @Test
    void from_createsIdeaName_onValidName() {
        // given
        String validName = "This is a valid idea name that meets the length requirements";

        // when
        IdeaNameVO ideaName = IdeaNameVO.from(validName);

        // then
        assertThat(ideaName).isNotNull();
        assertThat(ideaName.getNameValue()).isEqualTo(validName);
    }
    
    @Test
    void from_throwsException_onInvalidLengthName() {
        //TODO: Implement unit tests
    }

    @Test
    void getKeywords_returnsKeywords_onValidName() {
        // given
        String name = "Java Spring Boot Microservices";
        IdeaNameVO ideaName = IdeaNameVO.from(name);

        // when
        String[] keywords = ideaName.getKeywords();

        // then
        assertThat(keywords)
            .isNotNull()
            .hasSize(4)
            .containsExactly("Java", "Spring", "Boot", "Microservices");
    }
}