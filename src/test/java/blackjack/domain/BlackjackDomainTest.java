package blackjack.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Random;

import org.junit.jupiter.api.Test;

class BlackjackDomainTest {
    @Test
    void treatsAnAceAsElevenWhenItDoesNotBust() {
        Hand hand = new Hand(Card.ACE, Card.NINE);
        hand.add(Card.TWO);

        assertEquals(12, hand.bestScore());
        assertTrue(!hand.isBust());
    }

    @Test
    void downgradesAceToOneWhenElevenWouldBust() {
        Hand hand = new Hand(Card.ACE, Card.KING);
        hand.add(Card.NINE);

        assertEquals(20, hand.bestScore());
        assertTrue(!hand.isBust());
    }

    @Test
    void detectsBustAndComparesRoundOutcome() {
        Hand player = new Hand(Card.KING, Card.NINE);
        player.add(Card.FOUR);
        Hand dealer = new Hand(Card.TEN, Card.NINE);

        assertTrue(player.isBust());
        assertEquals(RoundResult.DEALER_WINS, BlackjackRules.compare(player, dealer));
    }

    @Test
    void createsAStandardDeckWithFourCopiesOfEachRank() {
        Deck deck = new Deck(new Random(7));
        assertEquals(52, deck.remainingCards());
        for (int i = 0; i < 52; i++) {
            deck.deal();
        }
        assertEquals(0, deck.remainingCards());
        assertThrows(IllegalStateException.class, deck::deal);
    }

    @Test
    void rejectsUnknownCardLabels() {
        assertThrows(IllegalArgumentException.class, () -> Card.fromLabel("Joker"));
    }
}
