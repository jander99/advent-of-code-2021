package com.github.jander99.advent.problems;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class Day8Tests {

    private static final String TEST_INPUT_FILE = "day8/test.txt";
    private static final String REAL_INPUT_FILE = "day8/input.txt";

    private static List<String> TEST_INPUT;
    private static List<String> REAL_INPUT;

    @BeforeAll
    static void setup() {
        TEST_INPUT = InputLoader.readLinesFromInputFile(TEST_INPUT_FILE);
        REAL_INPUT = InputLoader.readLinesFromInputFile(REAL_INPUT_FILE);
    }

    @Test
    public void partOne() {

        Day8 day8 = new Day8();
        int occurrences = day8.findUniqueDigits(TEST_INPUT);
        assertThat(occurrences).isEqualTo(26);

        int realOccurrences = day8.findUniqueDigits(REAL_INPUT);
        log.info("Day 8 Part 1: {}", realOccurrences);
    }

    @Test
    public void partTwo() {

        Day8 day8 = new Day8();
        int sumOfDecodedNumbers = day8.sumOutputNumbers(TEST_INPUT);
        assertThat(sumOfDecodedNumbers).isEqualTo(61229);

        int realSumOfDecodedNumbers = day8.sumOutputNumbers(REAL_INPUT);
        log.info("Day 8 Part 2: {}", realSumOfDecodedNumbers);
    }
}
