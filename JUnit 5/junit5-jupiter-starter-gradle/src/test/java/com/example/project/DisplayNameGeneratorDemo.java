package com.example.project;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class DisplayNameGeneratorDemo {
    @Nested
    class A_year_is_not_supported {

        @Test
        void if_it_is_zero() {

        }

    }

    @Nested
    @IndicativeSentencesGeneration(separator = "->", generator = DisplayNameGenerator.ReplaceUnderscores.class)
    class A_year_is_a_leap_year {

        @ParameterizedTest(name = "Year {0} is a leap year")
        @ValueSource(ints = {2016, 2020, 2048})
        void if_it_is_one_of_the_following_years(int year) {

        }

    }
}
