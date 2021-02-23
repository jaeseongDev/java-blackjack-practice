package blackjack.domain;

import static org.assertj.core.api.Assertions.assertThat;

import blackjack.domain.card.Card;
import blackjack.domain.card.Shape;
import blackjack.domain.card.Symbol;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CardsTest {
    @Test
    @DisplayName("생성한 카드 덱에서 총 52장이 정상적으로 생성되었는 지 테스트")
    public void init() {
        Cards cards = new Cards();
        for (Shape shape : Shape.values()) {
            for (Symbol symbol : Symbol.values()) {
                assertThat(cards.contains(new Card(shape, symbol))).isEqualTo(true);
            }
        }
    }
}
