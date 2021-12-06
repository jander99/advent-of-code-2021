package com.github.jander99.advent.problems;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


@Slf4j
public class Day4 {

    public List<Integer> readGameNumbers(String numbers) {
        return Arrays.stream(numbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public List<BingoCard> populateBingoCards(List<String> numberBlocks) {
        List<BingoCard> bingoCards = new ArrayList<>();

        Iterator<String> numberBlockIterator = numberBlocks.iterator();
        numberBlockIterator.next(); // Skip the game numbers

        int numberBoards = 0;
        while(numberBlockIterator.hasNext()) {
            if (StringUtils.isNoneEmpty(numberBlockIterator.next())) {
                continue; // Skip the empty lines between
            }
            List<String> oneBoardOfNumbers = new ArrayList<>();
            for (int i=0;i<5;i++) {
                oneBoardOfNumbers.add(numberBlockIterator.next());
            }
            BingoCard card = BingoCard.create(numberBoards, oneBoardOfNumbers);
            bingoCards.add(card);
            numberBoards++;
        }

        return bingoCards;
    }

    public Pair<BingoCard, Integer> getFirstWinningCard(List<BingoCard> cards, List<Integer> numbers) {
        return numbers.stream().map(number -> {
            playNumber(number, cards);
            return Pair.of(getWinningCard(cards),number);
        })
        .filter(bingo ->bingo.getKey().isPresent())
        .map(bingo -> Pair.of(bingo.getKey().get(), bingo.getRight()))
        .findFirst()
        .orElseThrow();
    }

    public Pair<BingoCard, Integer> getLastWinningCard(List<BingoCard> cards, List<Integer> numbers) {
        List<BingoCard> playingCards = new ArrayList<>();
        List<Pair<BingoCard, Integer>> completedCards = new ArrayList<>();

        playingCards.addAll(cards);

        for (Integer number : numbers) {
            if (completedCards.size() == cards.size()) {
                continue;
            }

            playNumber(number, playingCards);

            List<BingoCard> cardsThatJustWon = getWinningCards(playingCards);

            if (cardsThatJustWon.size() > 0) {
                cardsThatJustWon.forEach(card -> {
                    completedCards.add(Pair.of(card, number));
                    playingCards.remove(card);
                });
            }
        }

        return completedCards.get(completedCards.size() - 1);
    }

    private void playNumber(Integer number, List<BingoCard> cards) {
        cards.forEach(card -> card.stampCard(number));
    }

    private Optional<BingoCard> getWinningCard(List<BingoCard> cards) {
        return cards.stream()
                .filter(card -> card.hasWinningRow().isPresent() || card.hasWinningColumn().isPresent())
                .findFirst();
    }

    private List<BingoCard> getWinningCards(List<BingoCard> cards) {
        return cards.stream()
                .filter(card -> card.hasWinningRow().isPresent() || card.hasWinningColumn().isPresent())
                .collect(Collectors.toList());
    }
}

@Slf4j
@Data
class BingoCard {

    private int cardId;

    List<List<Pair<Integer, Boolean>>> elements = new ArrayList<>();

    public static BingoCard create(int boardId, List<String> lines) {
        assert lines.size() == 5;

        BingoCard bingoCard = new BingoCard();

        bingoCard.setCardId(boardId);

        AtomicInteger columnPos = new AtomicInteger(0);
        AtomicInteger rowPos = new AtomicInteger(0);


        lines.forEach(line -> {
            columnPos.set(0);

            Arrays.stream(line.split(" "))
                    .filter(StringUtils::isNoneEmpty)
                    .map(Integer::parseInt)
                    .forEach(number -> {
                        if(columnPos.getAndIncrement() == 0) {
                            bingoCard.elements.add(new ArrayList<>());
                        }

                        List<Pair<Integer, Boolean>> row =
                                bingoCard.elements.get(rowPos.get());

                        row.add(MutablePair.of(number, false));
                    });
            rowPos.incrementAndGet();
        });
        return bingoCard;
    }

    public void stampCard(int number) {
        this.elements.forEach(row -> {
            row.forEach(element -> {
                if (element.getKey().equals(number)) {
                    element.setValue(true);
                }
            });
        });
    }


    public Optional<List<Integer>> hasWinningRow() {
        return hasWinningRow(this.elements);
    }

    /** I should be able to flip the "matrix" and then check for rows now. */
    public Optional<List<Integer>> hasWinningColumn() {

        List<List<Pair<Integer, Boolean>>> flippedElements = IntStream.range(0, elements.get(0).size())
                . mapToObj(col -> elements
                        .stream()
                        .map(e -> e.get(col))
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());

        return hasWinningRow(flippedElements);
    }

    /** Overload this so that I can get columns from rows */
    private Optional<List<Integer>> hasWinningRow(List<List<Pair<Integer, Boolean>>> elements) {
        return elements.stream().map(row ->
                        row.stream().filter(Pair::getValue).map(Pair::getKey).collect(Collectors.toList()))
                .filter(row -> row.size() == 5).findFirst();
    }

    public int getSumOfUnstampedElements() {
        return elements
                .stream()
                .flatMap(Collection::stream)
                .filter(p -> !p.getValue())
                .map(Pair::getKey)
                .mapToInt(i->i)
                .sum();
    }


}
