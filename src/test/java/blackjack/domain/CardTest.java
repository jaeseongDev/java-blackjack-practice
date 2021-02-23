package blackjack.domain;

import static org.assertj.core.api.Assertions.assertThatCode;

import blackjack.domain.card.Card;
import blackjack.domain.card.Shape;
import blackjack.domain.card.Symbol;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CardTest {
    @Test
    @DisplayName("모양과 값을 가질 수 있는 카드 생성")
    public void init() {
        assertThatCode(() ->
            new Card(Shape.DIAMOND, Symbol.KING)
        ).doesNotThrowAnyException();
    }
}
