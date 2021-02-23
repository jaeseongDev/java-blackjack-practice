package blackjack.domain.participant;

import blackjack.domain.card.Card;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Participant {

    private static final int MIN_NAME_LENGTH = 1;

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
}
