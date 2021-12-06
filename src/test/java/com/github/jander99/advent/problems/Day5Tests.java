package com.github.jander99.advent.problems;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class Day5Tests {

    private static final String TEST_INPUT_FILE = "day5/test.txt";
    private static final String REAL_INPUT_FILE = "day5/input.txt";

    private static List<String> TEST_INPUT;
    private static List<String> REAL_INPUT;

    @BeforeAll
    static void setup() {
        TEST_INPUT = InputLoader.readLinesFromInputFile(TEST_INPUT_FILE);
        REAL_INPUT = InputLoader.readLinesFromInputFile(REAL_INPUT_FILE);
    }

    @Test
    @Disabled
    public void partOne() {

        Day5 day5 = new Day5();
        day5.processInstructions(TEST_INPUT);
        int dangerPoints = day5.howManyOverlappingLines(2);
        assertThat(dangerPoints).isEqualTo(5);

        day5 = new Day5();
        day5.processInstructions(REAL_INPUT);
        dangerPoints = day5.howManyOverlappingLines(2);
        log.info("Day 5, Part 1 {} ", dangerPoints);
    }

    @Test
    public void partTwo() {

        Day5 day5 = new Day5();
        day5.processInstructions(TEST_INPUT);
        int dangerPoints = day5.howManyOverlappingLines(2);
        assertThat(dangerPoints).isEqualTo(12);

        day5 = new Day5();
        day5.processInstructions(REAL_INPUT);
        dangerPoints = day5.howManyOverlappingLines(2);
        log.info("Day 5, Part 2 {} ", dangerPoints);

    }
}
