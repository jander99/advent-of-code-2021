package com.github.jander99.advent.problems;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class Day4 {

    private List<Integer> numbersToDraw;
    private List<BingoBoard> bingoBoards;

    public void fileParser(List<String> fileLines) {

    }

    public BingoBoard buildBoard(List<String> boardLines) {

        BingoBoard newBoard = new BingoBoard();

        for (String line : boardLines) {

        }



        return newBoard;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BingoBoard {

        private BingoCell[][] cells;

        public void setCell(int x, int y, int value, boolean marked) {
            cells[x][y] = BingoCell.builder().value(value).marked(marked).build();
        }

        public boolean isCellMarked(int x, int y) {
            return cells[x][y].isMarked();
        }
    }

    @Data
    @Builder
    public static class BingoCell {
        private int value;
        private boolean marked = false;
    }

}
