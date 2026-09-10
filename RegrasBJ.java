
import blackjack.domain.Card;
import blackjack.domain.Hand;

public class RegrasBJ {

    private final Hand hand;

    public RegrasBJ(String c1, String c2) {
        hand = new Hand(Card.fromLabel(c1), Card.fromLabel(c2));

    }//Fim do construtor

    public int GetCardTotal() {
        return hand.bestScore();
    }

    public void setCardTotal() {
        // Mantido para compatibilidade com a interface legada.
    }

    public void CardHit(String ca) {
        hand.add(Card.fromLabel(ca));
    }

    public boolean CheckBust() {
        return hand.isBust();
    }

}
