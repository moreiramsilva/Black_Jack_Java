package blackjack.domain;

import java.util.Locale;

public enum Card {
    ACE("As", 11, 1),
    TWO("2", 2, 2),
    THREE("3", 3, 3),
    FOUR("4", 4, 4),
    FIVE("5", 5, 5),
    SIX("6", 6, 6),
    SEVEN("7", 7, 7),
    EIGHT("8", 8, 8),
    NINE("9", 9, 9),
    TEN("10", 10, 10),
    JACK("Jack", 10, 10),
    QUEEN("Queen", 10, 10),
    KING("King", 10, 10);

    private final String label;
    private final int softValue;
    private final int hardValue;

    Card(String label, int softValue, int hardValue) {
        this.label = label;
        this.softValue = softValue;
        this.hardValue = hardValue;
    }

    public int softValue() {
        return softValue;
    }

    public int hardValue() {
        return hardValue;
    }

    public boolean isAce() {
        return this == ACE;
    }

    public static Card fromLabel(String label) {
        if (label == null) {
            throw new IllegalArgumentException("Card label must not be null");
        }
        String normalized = label.trim().toLowerCase(Locale.ROOT);
        for (Card card : values()) {
            if (card.label.toLowerCase(Locale.ROOT).equals(normalized)) {
                return card;
            }
        }
        throw new IllegalArgumentException("Unknown card: " + label);
    }

    @Override
    public String toString() {
        return label;
    }
}
