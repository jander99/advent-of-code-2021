package com.github.jander99.advent.problems;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Slf4j
@Data
public class Day6 {

    List<List<Integer>> fishes;
    int daysPassed = 0;

    public Day6() {
        fishes = new ArrayList<>();
    }

    public void setInitialFish(List<Integer> newFish) {
        fishes.add(newFish);
    }

    public void passDay() {

        List<Integer> nextGeneration = new ArrayList<>();
        List<List<Integer>> oldGenerations = new ArrayList<>();

        for(List<Integer> fishList : fishes) {
            List<Integer> newFishList = new ArrayList<>();
            fishList.forEach(fish -> {
                if(fish == 0) {
                    newFishList.add(6);
                    nextGeneration.add(8);
                } else {
                    newFishList.add(fish-1);
                }
            });
            oldGenerations.add(newFishList);
        }

        fishes = oldGenerations;

        if (nextGeneration.size() > 0) {
            fishes.add(nextGeneration);
        }

        daysPassed++;
    }

    public Long getTotalFishes() {
        AtomicLong total = new AtomicLong(0);
        fishes.forEach(fish -> {
            total.getAndAdd(fish.size());
        });

        return total.get();
    }
}
