package com.github.jander99.advent.problems;

import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class Day8 {


    public int findUniqueDigits(List<String> inputData) {

        AtomicInteger counter = new AtomicInteger(0);
        inputData.forEach(line ->
            counter.getAndAdd((int) Arrays.stream(line
                    .split("\\|")[1]
                    .split(" "))
                    .filter(s -> s.length() == 2
                            || s.length() == 3
                            || s.length() == 4
                            || s.length() == 7)
                            .count()));
        return counter.get();
    }

    @SuppressWarnings("OptionalGetWithoutIsPresent")
    public int sumOutputNumbers(List<String> inputData) {

        AtomicInteger counter = new AtomicInteger(0);
        inputData.forEach(line -> {
            List<String> signals = createSortedSignals(line
                    .split(" \\| ")[0]
                    .split(" "));
            List<String> data = createSortedSignals(line
                    .split(" \\| ")[1]
                    .split(" "));

            Map<Integer, String> decodedSignals = decodeSignals(signals);
            if(decodedSignals.size() != 10) {
                log.error("Signals {}", signals);
                log.error(String.valueOf(decodedSignals));
                assert decodedSignals.size() == 10;
            }

            counter.getAndAdd(Integer.parseInt(
            data.stream().map(element ->
                decodedSignals.entrySet()
                        .stream()
                        .filter(entry -> element.equalsIgnoreCase(entry.getValue()))
                        .map(Map.Entry::getKey)
                        .findFirst()
                        .get()
                        .toString()).collect(Collectors.joining())
            ));
        });

        return counter.get();
    }

    private List<String> createSortedSignals(String[] signals) {
        return Arrays.stream(signals)
                .map(s -> Stream.of(s.split(""))
                        .sorted()
                        .collect(Collectors.joining()))
                .collect(Collectors.toList());

    }

    private Map<Integer, String> decodeSignals(List<String> signals) {

        Map<Integer,String> decodedSignals = new HashMap<>();

        // We know the easy targets
        signals.forEach(signal -> {
            if(signal.length() == 2) {
                decodedSignals.put(1, signal);
            } else if (signal.length() == 3) {
                decodedSignals.put(7, signal);
            } else if (signal.length() == 4) {
                decodedSignals.put(4, signal);
            }else if (signal.length() == 7) {
                decodedSignals.put(8, signal);
            }
        });

        // The harder ones are derivatives of the easier ones
        signals.forEach(signal -> {
            if(signal.length() == 5) {
                if(doesBigStringHaveLittleStringCharacters(signal,decodedSignals.get(1))) {
                    decodedSignals.put(3, signal);
                } else if (doesBigStringHaveLittleStringCharacters(signal,removeAll(decodedSignals.get(4),decodedSignals.get(1)))) {
                    decodedSignals.put(5, signal);
                } else {
                    decodedSignals.put(2, signal);
                }
            } else if (signal.length() == 6) {
                if (doesBigStringHaveLittleStringCharacters(signal,decodedSignals.get(4))) {
                    decodedSignals.put(9, signal);
                } else if (doesBigStringHaveLittleStringCharacters(signal,decodedSignals.get(7))) {
                    decodedSignals.put(0, signal);
                } else {
                    decodedSignals.put(6, signal);
                }
            }
        });

        return decodedSignals;
    }

    private boolean doesBigStringHaveLittleStringCharacters(String big, String little) {
        return Stream.of(little.split("")).allMatch(big::contains);
    }

    private String removeAll(String big, String chars) {

        for(String a : chars.split("")) {
            big = big.replace(a,"");
        }

        return big;
    }
}
