package com.github.jander99.advent.problems;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Data
public class Day6 {

    List<Integer> fish;

    public Day6() {
        fish = new ArrayList<>();
    }

    public void setInitialFish(List<Integer> newFish) {
        fish.addAll(newFish);
    }

    public void passDay() {
        List<Integer> newFish = new ArrayList<>();

        fish.forEach(f -> {
            if (f == 0) {
                newFish.add(6);
                newFish.add(8);
            } else {
                newFish.add(f-1);
            }
        });

        fish = newFish;
    }
}
