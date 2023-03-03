package com.yobante.employe.controller;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class OnePlusOne {
   @Test
    public void assertOnePlusOne() {
        int somme = 1 + 1;
        assertThat(somme).isNotNull();
        assertThat(somme).isEqualTo(2);

    }
}
