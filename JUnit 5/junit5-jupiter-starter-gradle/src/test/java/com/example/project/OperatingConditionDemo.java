package com.example.project;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIf;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;

import static org.junit.jupiter.api.condition.JRE.JAVA_8;
import static org.junit.jupiter.api.condition.OS.MAC;
import static org.junit.jupiter.api.condition.OS.WINDOWS;

class OperatingConditionDemo {

    @Test
    @EnabledOnOs(MAC)
    void onlyOnMacOs() {

    }

    @Test
    @EnabledOnOs(WINDOWS)
    void onlyOnWindowOs() {

    }

    @Test
    @EnabledOnJre(JAVA_8)
    void onlyOnJava8() {

    }

    @Test
    @EnabledIf("customCondition")
    void enabled() {

    }

    boolean customCondition() {
        return true;
    }
}
