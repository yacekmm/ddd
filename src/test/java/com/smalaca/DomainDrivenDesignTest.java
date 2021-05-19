package com.smalaca;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DomainDrivenDesignTest {

    @Test
    void shouldRecognizeIfHelps() {
        boolean actual = new DomainDrivenDesign().doesItHelp();

        assertThat(actual).isTrue();
    }
}
