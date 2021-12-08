package com.github.jander99.advent.problems;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class Day7Tests {

    private static final String TEST_INPUT_FILE = "day7/test.txt";
    private static final String REAL_INPUT_FILE = "day7/input.txt";

    private static List<Integer> TEST_INPUT;
    private static List<Integer> REAL_INPUT;

    @BeforeAll
    static void setup() {
        TEST_INPUT = InputLoader.readSingleLineIntegerArrayFromInputFile(TEST_INPUT_FILE);
        REAL_INPUT = InputLoader.readSingleLineIntegerArrayFromInputFile(REAL_INPUT_FILE);
    }

    @Test
    @Disabled
    public void partOne() {

        Day7 day7 = new Day7();
        Integer totalDistance = day7.getTotalDistance(TEST_INPUT);
        assertThat(totalDistance).isEqualTo(37);

        totalDistance = day7.getTotalDistance(REAL_INPUT);
        log.info("Day 7 Part 1: {}", totalDistance);
    }

    @Test
    public void partTwo() {

        Day7 day7 = new Day7();
        var totalDistanceIncreasedFuelConsumption = day7.getTotalDistanceIncreasedFuelConsumption(TEST_INPUT);
        log.info("Test Rounded Average {}", totalDistanceIncreasedFuelConsumption);
        log.info("Test Summed Average {}", day7.getTotalDistanceIncreasedFuelConsumptionSummed(TEST_INPUT));
        assertThat(totalDistanceIncreasedFuelConsumption).isEqualTo(168);
        log.info("");
        log.info("");

        var totalDistanceSolution = day7.getTotalDistanceIncreasedFuelConsumptionSummed(REAL_INPUT);
        log.info("Real Rounded Average {}", day7.getTotalDistanceIncreasedFuelConsumption(REAL_INPUT));
        log.info("Real Summed Average {}", totalDistanceSolution);
        log.info("Day 7 Part 2: {}", totalDistanceSolution);


        // 98924524 too low
        // 98925034 too low
        // 98925035 too low
        // 98925151
        // 98925152 too high
        // 98925156 too high
    }
}
