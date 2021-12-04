package com.github.jander99.advent.problems;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class Day1Tests {

    private static final String TEST_INPUT_FILE = "day1/test.txt";
    private static final String REAL_INPUT_FILE = "day1/input.txt";

    private static List<Integer> TEST_INPUT_NUMBERS;
    private static List<Integer> REAL_INPUT_NUMBERS;

    @BeforeAll
    static void setup() {
        TEST_INPUT_NUMBERS = InputLoader.readIntegerLinesFromInputFile(TEST_INPUT_FILE);
        REAL_INPUT_NUMBERS = InputLoader.readIntegerLinesFromInputFile(REAL_INPUT_FILE);
    }


    @Test
    public void partOne() {

        Day1 day1 = new Day1();

        int numberTestIncreases = day1.countNumberIncreases(TEST_INPUT_NUMBERS);
        assertEquals(7, numberTestIncreases);

        int numberRealIncreases = day1.countNumberIncreases(REAL_INPUT_NUMBERS);
        log.info("Day 1, Part 1: {}", numberRealIncreases);

    }

    @Test
    public void partTwo() {

        Day1 day1 = new Day1();

        int numberTestIncreases = day1.countSlidingWindowIncreases(TEST_INPUT_NUMBERS);
        assertEquals(5, numberTestIncreases);

        int numberRealIncreases = day1.countSlidingWindowIncreases(REAL_INPUT_NUMBERS);
        log.info("Day 1, Part 2: {}", numberRealIncreases);

    }
}
