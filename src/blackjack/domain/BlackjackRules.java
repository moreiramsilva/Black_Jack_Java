package blackjack.domain;

public final class BlackjackRules {
    private BlackjackRules() {
    }

    public static RoundResult compare(Hand player, Hand dealer) {
        if (player == null || dealer == null) {
            throw new IllegalArgumentException("Player and dealer hands are required");
        }
        if (player.isBust()) {
            return RoundResult.DEALER_WINS;
        }
        if (dealer.isBust()) {
            return RoundResult.PLAYER_WINS;
        }
        if (player.bestScore() > dealer.bestScore()) {
            return RoundResult.PLAYER_WINS;
        }
        if (player.bestScore() < dealer.bestScore()) {
            return RoundResult.DEALER_WINS;
        }
        return RoundResult.PUSH;
    }
}
