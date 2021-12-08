package com.github.jander99.advent.problems;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Data
public class Day7 {

    public Integer getTotalDistance(List<Integer> positionList) {

        int[] sortedPositionList = positionList.stream()
                .sorted()
                .mapToInt(i->i)
                .toArray();

        double medianPosition = sortedPositionList[sortedPositionList.length / 2];

        return (int) positionList.stream()
                .map(p -> Math.abs(medianPosition-p))
                .mapToDouble(d -> d)
                .sum();
    }

    /** This method works for the Test Data */
    @SuppressWarnings("OptionalGetWithoutIsPresent")
    public Integer getTotalDistanceIncreasedFuelConsumption(List<Integer> positionList) {

        var average = (int)Math.round(positionList
                .stream()
                .mapToInt(i -> i)
                .average()
                .getAsDouble());

        var totalDistanceCost = 0;
        for (Integer position : positionList) {
            var distance = Math.abs(position - average);
            totalDistanceCost = totalDistanceCost + ((distance * (distance + 1)) / 2);
        }

        return totalDistanceCost;
    }

    /** But this method works for the Solution Data */
    @SuppressWarnings("OptionalGetWithoutIsPresent")
    public Integer getTotalDistanceIncreasedFuelConsumptionSummed(List<Integer> positionList) {

        var average = (positionList
                .stream()
                .mapToInt(i->i)
                .sum() / positionList.size());

        int totalDistanceCostInt = 0;
        for (Integer position : positionList) {
            var distance = Math.abs(position - average);
            totalDistanceCostInt = (int) (totalDistanceCostInt + ((distance * (distance + 1)) / 2));
        }

        return totalDistanceCostInt;
    }
}
