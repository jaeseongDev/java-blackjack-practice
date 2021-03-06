package blackjack.domain.participant;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import blackjack.domain.card.Card;
import blackjack.domain.card.CardDeck;
import blackjack.domain.card.Shape;
import blackjack.domain.card.Symbol;
import blackjack.domain.participant.Participant;
import java.util.Arrays;
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
        Participant player = new Player("jason");
        Participant dealer = new Dealer();

        CardDeck cardDeck = new CardDeck();
        List<Card> cards = cardDeck.handoutTwoCards();
        player.receive(cards);
        dealer.receive(cards);

        for (int i = 0; i < cards.size(); i++) {
            Card card = cards.get(i);
            assertThat(player.getCards().get(i)).isEqualTo(card);
            assertThat(dealer.getCards().get(i)).isEqualTo(card);
        }
    }

    @Test
    @DisplayName("카드 합계를 구하는 기능 테스트")
    public void getCardsSum() {
        Participant participant = new Participant("jason");
        CardDeck cardDeck = new CardDeck();
        List<Card> cards = cardDeck.handoutTwoCards();
        participant.receive(cards);
        int cardsSum = cards.stream()
             .mapToInt(card -> card.getValue())
             .sum();

        assertThat(participant.getCardsSum()).isEqualTo(cardsSum);
    }

    @Test
    @DisplayName("A를 11이라고 했을 때, 플레어이가 가진 카드의 합이 21을 초과할 경우 A를 1로 계산하기")
    public void getCardsSum_AceCardChange11To1() {
        Participant participant = new Participant("jason");
        participant.receive(Arrays.asList(
            new Card(Shape.CLOVER, Symbol.ACE), // 11 or 1
            new Card(Shape.CLOVER, Symbol.QUEEN), // 10
            new Card(Shape.CLOVER, Symbol.JACK) // 10
        ));
        assertThat(participant.getCardsSum()).isEqualTo(21);
    }
}
