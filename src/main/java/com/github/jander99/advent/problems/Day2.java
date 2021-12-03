package com.github.jander99.advent.problems;

import lombok.extern.slf4j.Slf4j;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

@Slf4j
public class Day2 {

    List<String> inputData;

    public Day2() throws Exception {
        inputData = Files.readAllLines(Paths.get("src/main/resources/day2input.txt"));
        log.info("There are {} numbers", inputData.size());
    }

    public void problem1() {

        AtomicInteger horiz = new AtomicInteger(0);
        AtomicInteger depth = new AtomicInteger(0);

        inputData.forEach(d -> {

            String[] command = d.split(" ", 2);
            if (command[0].equalsIgnoreCase("forward")) {
                horiz.getAndAdd(Integer.parseInt(command[1]));
            } else if (command[0].equalsIgnoreCase("down")) {
                depth.getAndAdd(Integer.parseInt(command[1]));
            } else if (command[0].equalsIgnoreCase("up")) {
                depth.getAndAdd(Integer.parseInt(command[1])*-1);
            }

        });

        log.info("Solution: {}", horiz.get()*depth.get());
    }

    public void problem2() {

        AtomicInteger horiz = new AtomicInteger(0);
        AtomicInteger depth = new AtomicInteger(0);
        AtomicInteger aim = new AtomicInteger(0);

        inputData.forEach(d -> {

            String[] command = d.split(" ", 2);
            if (command[0].equalsIgnoreCase("forward")) {
                horiz.getAndAdd(Integer.parseInt(command[1]));
                depth.getAndAdd(aim.get()*Integer.parseInt(command[1]));
            } else if (command[0].equalsIgnoreCase("down")) {
                aim.getAndAdd(Integer.parseInt(command[1]));
            } else if (command[0].equalsIgnoreCase("up")) {
                aim.getAndAdd(Integer.parseInt(command[1])*-1);
            }

        });

        log.info("Solution: {}", horiz.get()*depth.get());
    }

}
