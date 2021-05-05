package com.example.project;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class StandardTest {

    //? BeforeAll은 왜 static?
    @BeforeAll //클래스를 초기화할 때 딱 한 번
    static void initAll() {

    }

    @BeforeEach
    void init() {

    }

    @Test
    void succeedingTest() {

    }

    @Test
    void failingTest() {
        fail("a failing test");
    }

    @Test
    @Disabled("for demonstration purposes") //붙이면 무시됨
    void skippedTest() {

    }

    @Test
    void abortedTest() {
        assumeTrue("abc".contains("Z"));
        fail("test should have been aborted");
    }

    @AfterEach
    void tearDown() {

    }

    @AfterAll
    static void tearDownAll() {

    }
}
