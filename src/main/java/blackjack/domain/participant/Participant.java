package blackjack.domain.participant;

import blackjack.domain.card.Card;
import blackjack.domain.card.Symbol;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Participant {

    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_CARDS_SUM_TO_WIN = 21;
    private static final int GAP_WITH_ACE_OTHER_VALUE = 10;

    private final String name;
    private List<Card> cards = new ArrayList<>();

    public Participant(String name) {
        validateParticipantNameLength(name);
        this.name = name;
    }

    private void validateParticipantNameLength(String name) {
        if (name.trim().length() < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException("참가자 이름은 양쪽 끝 공백을 제거하고 1글자 이상이 되어야 합니다.");
        }
    }

    public void receive(List<Card> receivedCards) {
        cards.addAll(receivedCards);
    }

    public List<Card> getCards() {
        return Collections.unmodifiableList(cards);
    }

    public String getName() {
        return name;
    }

    public int getCardsSum() {
        int sum = cards.stream()
                       .mapToInt(card -> card.getValue())
                       .sum();
        if (containsAce() && sum > MAX_CARDS_SUM_TO_WIN) {
            return sum - GAP_WITH_ACE_OTHER_VALUE;
        }
        return sum;
    }

    private boolean containsAce() {
        return cards.stream()
                    .anyMatch(card -> card.isAce());
    }
}
