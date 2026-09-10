package blackjack.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Hand {
    private final List<Card> cards = new ArrayList<Card>();

    public Hand(Card first, Card second) {
        add(first);
        add(second);
    }

    public void add(Card card) {
        if (card == null) {
            throw new IllegalArgumentException("Card must not be null");
        }
        cards.add(card);
    }

    public List<Card> cards() {
        return Collections.unmodifiableList(cards);
    }

    public int bestScore() {
        int score = 0;
        int aces = 0;
        for (Card card : cards) {
            score += card.hardValue();
            if (card.isAce()) {
                aces++;
            }
        }
        while (aces > 0 && score + 10 <= 21) {
            score += 10;
            aces--;
        }
        return score;
    }

    public boolean isBust() {
        return bestScore() > 21;
    }

    public boolean isBlackjack() {
        return cards.size() == 2 && bestScore() == 21;
    }
}
