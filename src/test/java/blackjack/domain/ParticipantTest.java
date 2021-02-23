package blackjack.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import blackjack.domain.card.Card;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ParticipantTest {
    @ParameterizedTest(name = "{index} - {displayName}")
    @DisplayName("양쪽 끝 공백을 제거한 후, 1글자 이상의 이름을 가지지 않을 경우 예외 발생")
    @ValueSource(strings = { "", " ", "  " })
    public void validateNameLength(String name) {
        assertThatIllegalArgumentException().isThrownBy(() ->
            new Participant(name)
        );
    }

    @Test
    @DisplayName("게임 시작 시 카드를 2장 받는 기능이 제대로 작동하는 지 테스트")
    public void receiveCards() {
        Participant participant = new Participant("jason");
        CardDeck cardDeck = new CardDeck();
        List<Card> cards = cardDeck.handoutTwoCards();
        participant.receive(cards);

        for (int i = 0; i < cards.size(); i++) {
            assertThat(cards.get(i)).isEqualTo(participant.getCards().get(i));
        }
    }
}
