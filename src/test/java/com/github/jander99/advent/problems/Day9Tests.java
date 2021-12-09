package com.github.jander99.advent.problems;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class Day9Tests {

    private static final String TEST_INPUT_FILE = "day9/test.txt";
    private static final String REAL_INPUT_FILE = "day9/input.txt";

    private static List<String> TEST_INPUT;
    private static List<String> REAL_INPUT;

    @BeforeAll
    static void setup() {
        TEST_INPUT = InputLoader.readLinesFromInputFile(TEST_INPUT_FILE);
        REAL_INPUT = InputLoader.readLinesFromInputFile(REAL_INPUT_FILE);
    }

    @Test
    public void partOne() {

        Day9 day9 = new Day9();
        assertThat(true).isTrue();

    }

    @Test
    public void partTwo() {

        Day9 day9 = new Day9();
        assertThat(true).isTrue();
    }
}
