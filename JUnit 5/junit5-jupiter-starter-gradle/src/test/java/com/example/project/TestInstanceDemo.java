package com.example.project;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TestInstanceDemo {

    @BeforeAll
    void setUp() {
    }

    @AfterAll
    void clean() {
    }

    @Test
    void test() {

    }
}
