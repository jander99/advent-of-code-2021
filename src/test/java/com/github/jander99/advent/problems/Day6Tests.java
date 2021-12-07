package com.github.jander99.advent.problems;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class Day6Tests {

    private static final String TEST_INPUT_FILE = "day6/test.txt";
    private static final String REAL_INPUT_FILE = "day6/input.txt";

    private static List<String> TEST_INPUT;
    private static List<String> REAL_INPUT;

    @BeforeAll
    static void setup() {
        TEST_INPUT = InputLoader.readLinesFromInputFile(TEST_INPUT_FILE);
        REAL_INPUT = InputLoader.readLinesFromInputFile(REAL_INPUT_FILE);
    }

    @Test
    public void partOne() {

        Day6 day6 = new Day6();
        List<Integer> freshFish = Arrays
                .stream(TEST_INPUT.get(0).split(","))
                .mapToInt(Integer::parseInt).boxed().toList();

        day6.setInitialFish(freshFish);
        int numDays = 80;
        for(int i=0;i<numDays;i++) {
            day6.passDay();
        }
        long numFish = day6.getTotalFishes();
        assertThat(numFish).isEqualTo(5934);

        day6 = new Day6();
        freshFish = Arrays
                .stream(REAL_INPUT
                        .get(0)
                        .split(","))
                .mapToInt(Integer::parseInt)
                .boxed()
                .toList();

        day6.setInitialFish(freshFish);
        numDays = 80;
        for(int i=0;i<numDays;i++) {
            day6.passDay();
        }
        numFish = day6.getTotalFishes();
        log.info("Day 6, Part 1 {} ", numFish);
    }

    @Test
    public void partTwo() {

        Day6 day6 = new Day6();
        int numDays = 256;

        List<Integer> freshFish = Arrays
                .stream(TEST_INPUT
                        .get(0)
                        .split(","))
                .mapToInt(Integer::parseInt)
                .boxed()
                .toList();

        day6.setInitialFish(freshFish);
        for(int i=0;i<numDays;i++) {
            day6.passDay();
        }
        long numFish = day6.getTotalFishes();
        assertThat(numFish).isEqualTo(26984457539L);

        day6 = new Day6();
        freshFish = Arrays
                .stream(REAL_INPUT
                        .get(0)
                        .split(","))
                .mapToInt(Integer::parseInt)
                .boxed()
                .toList();

        day6.setInitialFish(freshFish);
        for(int i=0;i<numDays;i++) {
            day6.passDay();
        }
        numFish = day6.getTotalFishes();
        log.info("Day 6, Part 2 {} ", numFish);
    }
}
