package com.github.jander99.advent.problems;


import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class Day4Tests {

    private static final String TEST_INPUT_FILE = "day4/test.txt";
    private static final String REAL_INPUT_FILE = "day4/input.txt";

    private static List<String> TEST_INPUT;
    private static List<String> REAL_INPUT;

    @BeforeAll
    static void setup() {
        TEST_INPUT = InputLoader.readLinesFromInputFile(TEST_INPUT_FILE);
        REAL_INPUT = InputLoader.readLinesFromInputFile(REAL_INPUT_FILE);
    }

    @Test
    public void sanityCheck() {

        List<String> sampleBoard = List.of("1  2 3 4 5", "2 3 14 5 6",
                "3 4 5 6  7", " 4 5 6 7 8","5 6 7 8  9");

        BingoCard card = BingoCard.create(99, sampleBoard);

        assertThat(card.hasWinningRow().isPresent()).isFalse();
        assertThat(card.hasWinningColumn().isPresent()).isFalse();

        card.stampCard(3);
        card.stampCard(4);
        card.stampCard(5);
        card.stampCard(6);
        card.stampCard(7);

        assertThat(card.hasWinningRow().isPresent()).isTrue();
        assertThat(card.hasWinningColumn().isPresent()).isFalse();
        assertThat(card.hasWinningRow().get()).containsExactly(3,4,5,6,7);

        card.stampCard(8);

        assertThat(card.hasWinningRow().isPresent()).isTrue();
        assertThat(card.hasWinningRow().get()).containsExactly(3,4,5,6,7);
        assertThat(card.hasWinningColumn().isPresent()).isTrue();
        assertThat(card.hasWinningColumn().get()).containsExactly(4,5,6,7,8);
    }

    @Test
    public void partOne() {

        Day4 day4 = new Day4();
        List<Integer> numbersToDraw = day4.readGameNumbers(TEST_INPUT.get(0));
        List<BingoCard> bingoCards = day4.populateBingoCards(TEST_INPUT);

        assertThat(bingoCards).hasSize(3);

        Pair<BingoCard, Integer> firstWinner = day4.getFirstWinningCard(bingoCards, numbersToDraw);
        BingoCard card = firstWinner.getKey();
        int winningNumber = firstWinner.getValue();
        int sumOfABitch = card.getSumOfUnstampedElements();

        assertThat(card.hasWinningRow().isPresent()).isTrue();
        assertThat(card.hasWinningRow().get()).containsExactly(14,21,17,24,4);
        assertThat(winningNumber).isEqualTo(24);
        assertThat(sumOfABitch).isEqualTo(188);


        numbersToDraw = day4.readGameNumbers(REAL_INPUT.get(0));
        bingoCards = day4.populateBingoCards(REAL_INPUT);


        firstWinner = day4.getFirstWinningCard(bingoCards, numbersToDraw);
        card = firstWinner.getKey();
        winningNumber = firstWinner.getValue();
        sumOfABitch = card.getSumOfUnstampedElements();

        int answer = winningNumber * sumOfABitch;

        log.info("Day 4, Part 1: {}", answer);
    }

    @Test
    public void partTwo() {

        Day4 day4 = new Day4();
        List<Integer> numbersToDraw = day4.readGameNumbers(TEST_INPUT.get(0));
        List<BingoCard> bingoCards = day4.populateBingoCards(TEST_INPUT);

        assertThat(bingoCards).hasSize(3);

        Pair<BingoCard, Integer> lastWinner = day4.getLastWinningCard(bingoCards, numbersToDraw);
        BingoCard card = lastWinner.getKey();
        int winningNumber = lastWinner.getValue();
        int sumOfABitch = card.getSumOfUnstampedElements();

        assertThat(winningNumber).isEqualTo(13);
        assertThat(sumOfABitch).isEqualTo(148);

        numbersToDraw = day4.readGameNumbers(REAL_INPUT.get(0));
        bingoCards = day4.populateBingoCards(REAL_INPUT);


        lastWinner = day4.getLastWinningCard(bingoCards, numbersToDraw);
        card = lastWinner.getKey();
        winningNumber = lastWinner.getValue();
        sumOfABitch = card.getSumOfUnstampedElements();

        int answer = winningNumber * sumOfABitch;

        log.info("Day 4, Part 2: {}", answer);

    }
}
