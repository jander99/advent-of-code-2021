package com.github.jander99.advent.problems;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class Day2 {

    public int calculateDepthHeading(List<String> inputData) {

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

        return horiz.get()*depth.get();
    }

    public int calculateAimHeading(List<String> inputData) {

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

        return horiz.get()*depth.get();
    }
}
