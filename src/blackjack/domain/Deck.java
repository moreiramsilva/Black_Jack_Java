package blackjack.domain;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.Random;

public final class Deck {
    private final Deque<Card> cards = new ArrayDeque<Card>();

    public Deck() {
        this(new Random());
    }

    public Deck(Random random) {
        if (random == null) {
            throw new IllegalArgumentException("Random source must not be null");
        }
        List<Card> shuffled = new ArrayList<Card>();
        for (Card card : Card.values()) {
            for (int copy = 0; copy < 4; copy++) {
                shuffled.add(card);
            }
        }
        Collections.shuffle(shuffled, random);
        cards.addAll(shuffled);
    }

    public int remainingCards() {
        return cards.size();
    }

    public Card deal() {
        Card card = cards.pollFirst();
        if (card == null) {
            throw new IllegalStateException("Cannot deal from an empty deck");
        }
        return card;
    }
}
