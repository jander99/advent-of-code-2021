package com.github.jander99.advent.problems;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

@Slf4j
public class Day8Tests {

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
    public void partOne() {

    }

    @Test
    public void partTwo() {

    }
}