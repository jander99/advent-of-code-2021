package com.github.jander99.advent.problems;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class Day1 {

    public Integer countNumberIncreases(List<Integer> numberList) {

        Integer counter = -1;
        Integer previous = 0;

        for (Integer current : numberList) {
            if(current > previous) {
                counter++;
            }
            previous = current;
        }
        return counter;
    }

    public Integer countSlidingWindowIncreases(List<Integer> numberList) {

        List<Integer> slidingWindow = generateSlidingWindow(numberList);
        return countNumberIncreases(slidingWindow);
    }

//    public void run2() {
//
//        Integer counter = -1;
//        Integer previous = 0;
//
//        for (Integer current : slidingWindow) {
//            if (current > previous) {
//                counter++;
//                log.info("YAY {} is larger than {}- {}", current, previous, counter);
//            } else {
//                log.info("BOO {} is smaller than {} - {}", current, previous, counter);
//            }
//            previous = current;
//        }
//
//        log.info("There were {} measurements larger than the previous", counter);
//    }
//
    private List<Integer> generateSlidingWindow(List<Integer> input) {
        List<Integer> slidingWindow = new ArrayList<>();

        for (int i = 0; i < input.size()-2; i++) {
            slidingWindow.add(input.get(i) + input.get(i + 1) + input.get(i + 2));
        }

        return slidingWindow;
    }

}
