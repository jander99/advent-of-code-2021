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

    private void drawLine(int x1, int y1, int x2, int y2) {

        // Filter out non-viable pairs
        if (!isLineProper(x1, y1, x2, y2)) {
            return;
        }

        if(x1 == x2) {
            if(y2-y1>0) {
                for(int i=y1;i<=y2;i++) {
                    plotPoint(x1, i);
                }
            } else {
                for (int i=y1;i>=y2;i--) {
                    plotPoint(x1, i);
                }
            }
        } else if (y1 == y2){
            if(x2-x1 > 0) {
                for(int i=x1;i<=x2;i++) {
                    plotPoint(i, y1);
                }
            } else {
                for(int i=x1;i>=x2;i--) {
                    plotPoint(i, y1);
                }
            }
        } else {
//
//            // How do this?
//            int deltaX = x2-x1;
//            int deltaY = y2-y1;
//
//
//
//            if(deltaX > 0) { // X goes UP
//                for(int i=x1;i<=x2;i++) {
//                    if(deltaY > 0) { // Y goes UP too
//                        plotPoint(x1+i, y1+i);
//                    } else {
//                        plotPoint(x1 + i, y1 - i);
//                    }
//                }
//            } else {
//                for(int i=x1;i>=x2;i--) {
//                    if(deltaY > 0) { // Y goes UP too
//                        plotPoint(x1+i, y1+i);
//                    } else {
//                        plotPoint(x1 + i, y1 - i);
//                    }
//                }
//            }


            while(x1 != x2 && y1 != y2) {
                plotPoint(x1, y1);
                x1 = x2-x1 < 0 ? x1-1 : x1+1;
                y1 = y2-y1 < 0 ? y1-1 : y1+1;
            }
        }
    }

    private boolean isLineProper(int x1, int y1, int x2, int y2) {

        double angle = Math.toDegrees(Math.atan2(y2 - y1, x2-x1))+360;
        return angle % 90 == 0 || angle % 180 == 0 || angle % 45 == 0;
    }

    public void processInstructions(List<String> instructions) {
        instructions.forEach(line -> {
            String[] points = line.split(" -> ");
            String[] a = points[0].split(",");
            String[] b = points[1].split(",");

            drawLine(Integer.parseInt(a[0]), Integer.parseInt(a[1]),
                    Integer.parseInt(b[0]), Integer.parseInt(b[1]));
        });
    }

    public int howManyOverlappingLines(int overlap) {

//        AtomicInteger count = new AtomicInteger(0);

        return Long.valueOf(hashPoints.values().stream().filter(v -> v >= overlap).count()).intValue();

//        points.forEach(t -> {
//            if(t.getRight()>=overlap) {
//                count.getAndIncrement();
//            }
//        });
//
//        return count.get();
    }
}

