package blackjack.domain;

import static org.assertj.core.api.Assertions.assertThat;

import blackjack.domain.card.Card;
import blackjack.domain.card.Shape;
import blackjack.domain.card.Symbol;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CardDeckTest {
    @Test
    @DisplayName("생성한 카드 덱에서 총 52장이 정상적으로 생성되었는 지 테스트")
    public void init() {
        CardDeck cardDeck = new CardDeck();
        for (Shape shape : Shape.values()) {
            for (Symbol symbol : Symbol.values()) {
                assertThat(cardDeck.contains(new Card(shape, symbol))).isEqualTo(true);
            }
        }
    }

    @Test
    @DisplayName("2장의 카드를 정상적으로 리턴하는 지 테스트")
    public void handoutTwoCards() {
        CardDeck cardDeck = new CardDeck();
        List<Card> cards = cardDeck.handoutTwoCards();
        assertThat(cards.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("1장의 카드를 정상적으로 리턴하는 지 테스트")
    public void handoutOneCard() {
        CardDeck cardDeck = new CardDeck();
        List<Card> cards = cardDeck.handoutOneCard();
        assertThat(cards.size()).isEqualTo(1);
    }
}
