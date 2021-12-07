package com.github.jander99.advent.problems;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.tuple.Pair;

import java.util.HashMap;
import java.util.List;


@Slf4j
@Data
public class Day5 {

    private HashMap<Pair<Integer, Integer>, Integer> hashPoints;

    public Day5() {
        hashPoints = new HashMap<>();
    }

    private void plotPoint(int x, int y) {

        Pair<Integer, Integer> tempPair = Pair.of(x, y);

        if(hashPoints.containsKey(tempPair)) {
            hashPoints.put(tempPair, hashPoints.get(tempPair)+1);
        } else {
            hashPoints.put(tempPair, 1);
        }
    }

    private void drawLine(int x1, int y1, int x2, int y2, boolean diagonals) {

        if (x1 < x2) {
            if(y1 == y2) {
                for(int x = x1;x<=x2;x++) {
                    plotPoint(x,y1);
                }
            }

            if(!diagonals || !isDiagonalLine(x1, y1, x2, y2)) {
                return;
            }

            int step = 0;
            for(int x=x1;x<=x2;x++) {
                if(y1 < y2) {
                    plotPoint(x, y1+step);
                } else {
                    plotPoint(x, y1-step);
                }
                step++;
            }
        } else if (x1 > x2) {
            if(y1 == y2) {
                for(int x = x1;x>=x2;x--) {
                    plotPoint(x,y1);
                }
            }

            if(!diagonals || !isDiagonalLine(x1, y1, x2, y2)) {
                return;
            }

            int step = 0;
            for(int x=x1;x>=x2;x--) {
                if(y1 < y2) {
                    plotPoint(x, y1+step);
                } else {
                    plotPoint(x, y1-step);
                }
                step++;
            }
        } else {
            if(y1 < y2) {
                for(int y=y1;y<=y2;y++) {
                    plotPoint(x1,y);
                }
            } else if (y1 > y2){
                for(int y=y1;y>=y2;y--) {
                    plotPoint(x1,y);
                }
            }
        }
    }

    private boolean isDiagonalLine(int x1, int y1, int x2, int y2) {
        return Math.abs(x1-x2) == Math.abs(y1-y2);

    }

    public void processInstructions(List<String> instructions, boolean diagonals) {
        instructions.forEach(line -> {
            String[] points = line.split(" -> ");
            String[] a = points[0].split(",");
            String[] b = points[1].split(",");

            drawLine(Integer.parseInt(a[0]), Integer.parseInt(a[1]),
                    Integer.parseInt(b[0]), Integer.parseInt(b[1]), diagonals);
        });
    }

    public Long howManyOverlappingLines(int overlap) {
        return hashPoints.values().stream().filter(v -> v >= overlap).count();
    }
}

