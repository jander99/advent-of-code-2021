package com.github.jander99.advent.problems;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class Day3Tests {
    private static final String TEST_INPUT_FILE = "day3/test.txt";
    private static final String REAL_INPUT_FILE = "day3/input.txt";

    private static List<String> TEST_INPUT;
    private static List<String> REAL_INPUT;

    @BeforeAll
    static void setup() {
        TEST_INPUT = InputLoader.readLinesFromInputFile(TEST_INPUT_FILE);
        REAL_INPUT = InputLoader.readLinesFromInputFile(REAL_INPUT_FILE);
    }

    @Test
    public void partOne() {

        Day3 day3 = new Day3();

        String mostCommonBinaryByPosition = day3.getMostCommonBitsByPosition(TEST_INPUT);
        assertEquals("10110", mostCommonBinaryByPosition);
        int gammaRate = Integer.parseInt(mostCommonBinaryByPosition, 2);
        assertEquals(22, gammaRate);

        int epsilonRate = Integer.parseInt(day3.flipBits(mostCommonBinaryByPosition),2);
        assertEquals(9, epsilonRate);

        int powerConsumption = gammaRate * epsilonRate;
        assertEquals(198, powerConsumption);

        mostCommonBinaryByPosition = day3.getMostCommonBitsByPosition(REAL_INPUT);
        gammaRate = Integer.parseInt(mostCommonBinaryByPosition, 2);
        epsilonRate = Integer.parseInt(day3.flipBits(mostCommonBinaryByPosition),2);
        powerConsumption = gammaRate * epsilonRate;

        log.info("Day 3, Part 1: {}", powerConsumption);
    }

    @Test
    public void partTwo() {

        Day3 day3 = new Day3();

        String mostFilteredBits = day3.getFilteredCommonBits(TEST_INPUT, Day3.FilterType.MOST);
        String leastFilteredBits = day3.getFilteredCommonBits(TEST_INPUT, Day3.FilterType.LEAST);
        int oxyGeneratorRating = Integer.parseInt(mostFilteredBits, 2);
        int co2ScrubberRating = Integer.parseInt(leastFilteredBits, 2);
        int lifeSupportRating = oxyGeneratorRating * co2ScrubberRating;

        assertEquals("10111", mostFilteredBits);
        assertEquals("01010", leastFilteredBits);
        assertEquals(23, oxyGeneratorRating);
        assertEquals(10, co2ScrubberRating);
        assertEquals(230, lifeSupportRating);

        mostFilteredBits = day3.getFilteredCommonBits(REAL_INPUT, Day3.FilterType.MOST);
        leastFilteredBits = day3.getFilteredCommonBits(REAL_INPUT, Day3.FilterType.LEAST);
        oxyGeneratorRating = Integer.parseInt(mostFilteredBits, 2);
        co2ScrubberRating = Integer.parseInt(leastFilteredBits, 2);
        lifeSupportRating = oxyGeneratorRating * co2ScrubberRating;

        log.info("Day 3, Part 2: {}", lifeSupportRating);
    }
}
