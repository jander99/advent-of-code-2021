package com.github.jander99.advent.problems;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

@Slf4j
public class Day1 {

    private List<String> input;
    private List<Integer> slidingWindow;

    public Day1() throws IOException {

        input = Files.readAllLines(Paths.get("src/main/resources/day1input.txt"));
        log.info("There are {} numbers", input.size());
    }

    public void run1() {

        Integer counter = -1;
        Integer previous = 0;

        for (String currentStr : input) {
            Integer current = Integer.parseInt(currentStr);
            if (current > previous) {
                counter++;
                log.info("YAY {} is larger than {}- {}", current, previous, counter);
            } else {
                log.info("BOO {} is smaller than {} - {}", current, previous, counter);
            }
            previous = current;
        }

        log.info("There were {} measurements larger than the previous", counter);
    }

    public void run2() {
        slidingWindow = new ArrayList<>();
        generateSlidingWindow();

        Integer counter = -1;
        Integer previous = 0;

        for (Integer current : slidingWindow) {
            if (current > previous) {
                counter++;
                log.info("YAY {} is larger than {}- {}", current, previous, counter);
            } else {
                log.info("BOO {} is smaller than {} - {}", current, previous, counter);
            }
            previous = current;
        }

        log.info("There were {} measurements larger than the previous", counter);
    }

    private void generateSlidingWindow() {


        for (int i = 0; i < input.size()-2; i++) {

            int a = 0;
            int b = 0;
            int c = 0;

            a = Integer.parseInt(input.get(i));
            b = Integer.parseInt(input.get(i + 1));
            c = Integer.parseInt(input.get(i + 2));
            slidingWindow.add(a + b + c);
        }
    }

}
