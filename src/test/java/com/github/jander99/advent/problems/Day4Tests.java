package com.github.jander99.advent.problems;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Day4Tests {

    private static final String TEST_INPUT_FILE = "day4/test.txt";
    private static final String REAL_INPUT_FILE = "day4/input.txt";

    private static List<String> TEST_INPUT;
    private static List<String> REAL_INPUT;

    @BeforeAll
    static void setup() {
        TEST_INPUT = InputLoader.readLinesFromInputFile(TEST_INPUT_FILE);
        REAL_INPUT = InputLoader.readLinesFromInputFile(REAL_INPUT_FILE);
    }


    @Test
    public void partOne() {

    }
}
