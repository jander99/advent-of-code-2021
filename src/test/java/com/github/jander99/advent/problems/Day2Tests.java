package com.github.jander99.advent.problems;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class Day2Tests {

    private static final String TEST_INPUT_FILE = "day2/test.txt";
    private static final String REAL_INPUT_FILE = "day2/input.txt";

    private static List<String> TEST_INPUT;
    private static List<String> REAL_INPUT;

    @BeforeAll
    static void setup() {
        TEST_INPUT = InputLoader.readLinesFromInputFile(TEST_INPUT_FILE);
        REAL_INPUT = InputLoader.readLinesFromInputFile(REAL_INPUT_FILE);
    }

    @Test
    public void partOne() {
        Day2 day2 = new Day2();

        int testDepthHeading = day2.calculateDepthHeading(TEST_INPUT);
        assertEquals(150, testDepthHeading);

        int realDepthHeading = day2.calculateDepthHeading(REAL_INPUT);
        log.info("Day 2, Part 1: {}", realDepthHeading);
    }

    @Test
    public void partTwo() {
        Day2 day2 = new Day2();

        int testAimHeading = day2.calculateAimHeading(TEST_INPUT);
        assertEquals(900, testAimHeading);

        int realAimHeading = day2.calculateAimHeading(REAL_INPUT);
        log.info("Day 2, Part 2: {}", realAimHeading);
    }
}
