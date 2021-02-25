package blackjack.domain.participant;

import static org.assertj.core.api.Assertions.assertThat;

import blackjack.domain.card.Card;
import blackjack.domain.card.Shape;
import blackjack.domain.card.Symbol;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class PlayerTest {

    @ParameterizedTest(name = "{index} - {displayName}")
    @DisplayName("딜러, 플레이어의 카드 합에 따라서 승패 결정")
    @MethodSource("generateData")
    public void isWin_playerWin(List<Card> playerCards, List<Card> dealerCards, boolean isWin) {
        Player player = new Player("jason");
        Participant dealer = new Dealer();
        player.receive(playerCards);
        dealer.receive(dealerCards);
        assertThat(player.isWin(dealer)).isEqualTo(isWin);
    }

    private static Stream<Arguments> generateData() {
        List<Card> fiveCards = Arrays.asList(
            new Card(Shape.CLOVER, Symbol.TWO),
            new Card(Shape.CLOVER, Symbol.THREE)
        );
        List<Card> nineteenCards = Arrays.asList(
            new Card(Shape.CLOVER, Symbol.NINE),
            new Card(Shape.CLOVER, Symbol.TEN)
        );
        List<Card> thirtyCards = Arrays.asList(
            new Card(Shape.CLOVER, Symbol.KING),
            new Card(Shape.CLOVER, Symbol.QUEEN),
            new Card(Shape.CLOVER, Symbol.JACK)
        );

        return Stream.of(
            Arguments.of(nineteenCards, fiveCards, true),
            Arguments.of(fiveCards, nineteenCards, false),
            Arguments.of(thirtyCards, thirtyCards, false),
            Arguments.of(fiveCards, thirtyCards, true)
        );
    }
}
