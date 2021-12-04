package com.github.jander99.advent.problems;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
public class Day3 {

    enum FilterType {
        MOST,
        LEAST,
    }

    public String getFilteredCommonBits(List<String> inputData, FilterType filterType) {
        int inputDataRowLength = inputData.get(0).length();

        List<String> filteredInputData = new ArrayList<>(inputData);

        IntStream.range(0, inputDataRowLength).forEach(position -> {
            if (filteredInputData.size() == 1) {
                return;
            }

            // This is basically recomputing gamma after each filter.
            String mostCommonBits = getMostCommonBitsByPosition(filteredInputData);
            final String commonBits = filterType == FilterType.MOST ? mostCommonBits : flipBits(mostCommonBits);

            List<String> inputDataToKeep = filteredInputData.stream()
                    .filter(line -> line.charAt(position) == commonBits.charAt(position))
                    .collect(Collectors.toList());

            // Reset for this position.
            filteredInputData.clear();
            filteredInputData.addAll(inputDataToKeep);
        });

        return filteredInputData.get(0);
    }


    public String getMostCommonBitsByPosition(List<String> inputData) {
        int inputDataRowLength = inputData.get(0).length();

        StringBuilder mostCommonBinary = new StringBuilder();

        IntStream.range(0, inputDataRowLength).forEach(position -> {
            int sum = inputData.stream()
                    .map(row -> Integer.parseInt(String.valueOf(row.charAt(position))))
                    .mapToInt(n -> n == 1 ? 1 : -1) // If it's 0, actually decrement the running sum.
                    .sum();
            int mostCommonInt = sum == 0 ? 1 : (sum > 0 ? 1 : 0);
            mostCommonBinary.append(mostCommonInt);
        });
        return mostCommonBinary.toString();
    }

    private int mostCommonBit(List<String> list, int position) {
        return list.stream().filter(s -> s.charAt(position) == '0').count() > list.size()/2 ? 0 : 1;
    }

    public String flipBits(String bits) {
        return bits.replaceAll("0", "2")
                .replaceAll("1", "0")
                .replaceAll("2", "1");
    }

//    private void generateData() {
//
//        inputDataRowLength = inputData.get(0).length();
//        inputDataNumRows = inputData.size();
//
//        inputMatrix = new int[inputDataRowLength][inputDataNumRows];
//
//        countZeros = new int[inputDataRowLength];
//        Arrays.fill(countZeros, 0);
//
//
//        /**
//         * Building the [x][y] matrix. x=i, y=j in the loop.
//         * First we read each row by iterating through inputData.get(j)
//         * Second we read each character of the row for x.
//         *
//         * We are also going to count the number of times in each x position
//         * that we encounter a zero character. If the number of zeros is greater
//         * than half, then that position gets a zero, otherwise it's a one.
//         */
//        for(int j=0;j<inputDataNumRows;j++) {
//
//            String row = inputData.get(j);
//            for(int i=0;i<inputDataRowLength;i++) {
//                int value = Integer.parseInt(String.valueOf(row.charAt(i)));
//                inputMatrix[i][j] = value;
//                if (value == 0) {
//                    countZeros[i]++;
//                }
//            }
//        }
//    }
}
