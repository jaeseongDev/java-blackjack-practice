package blackjack.view;

import static java.util.stream.Collectors.joining;

import blackjack.domain.participant.Dealer;
import blackjack.domain.participant.Participant;
import blackjack.domain.participant.Player;
import java.util.List;

public class OutputView {

    private static final String DELIMITER = ", ";

    private OutputView() {
    }

    public static void printInitHandOutCards(Dealer dealer, List<Player> players) {
        String playersNames = players.stream()
                                     .map(Player::getName)
                                     .collect(joining(DELIMITER));
        System.out.println(dealer.getName() + "와 " + playersNames + "에게 2장을 나누었습니다.");
    }

    public static void printDealerCards(Dealer dealer) {
        String cards = parseToCards(dealer);
        System.out.println(dealer.getName() + ": " + cards);
    }

    public static void printPlayersCards(List<Player> players) {
        for (Player player : players) {
            String cards = parseToCards(player);
            System.out.println(player.getName() + "카드: " + cards);
        }

    }

    private static String parseToCards(Participant participant) {
        return participant.getCards()
                          .stream()
                          .map(card -> card.getSymbol().getName() + card.getShape().getName())
                          .collect(joining(DELIMITER));
    }
}
