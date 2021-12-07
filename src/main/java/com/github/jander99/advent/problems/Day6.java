package com.github.jander99.advent.problems;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Data
public class Day6 {

    Long[] fishCounts;
    int daysPassed = 0;

    public Day6() {
        fishCounts = new Long[]{0L,0L,0L,0L,0L,0L,0L,0L,0L};
    }

    public void setInitialFish(List<Integer> newFish) {
        newFish.forEach(i -> fishCounts[i]++);
    }

    public void passDay() {
        Long zeroFish = fishCounts[0];
        for(int i=0;i<fishCounts.length;i++) {
            if(i != fishCounts.length-1) {
                fishCounts[i]=fishCounts[i+1];
            } else {
                fishCounts[i]=zeroFish;
                fishCounts[6]+=zeroFish;
            }
        }
        daysPassed++;
    }

    public Long getTotalFishes() {

        Long total = 0L;
        for (Long fishCount : fishCounts) {
            total += fishCount;
        }
        return total;
    }
}
