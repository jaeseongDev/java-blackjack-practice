package blackjack.domain.participant;

public class Player extends Participant {
    private static final int MAX_CARDS_SUM = 21;

    public Player(String name) {
        super(name);
    }

    public boolean isWin(Participant opponent) {
        int myCardsSum = getCardsSum();
        int opponentCardsSum = opponent.getCardsSum();
        if (myCardsSum > MAX_CARDS_SUM) {
            return false;
        }
        if (opponentCardsSum > MAX_CARDS_SUM) {
            return true;
        }
        if (myCardsSum > opponentCardsSum) {
            return true;
        }
        return false;
    }
}
