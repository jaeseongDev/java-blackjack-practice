package blackjack.view;

import blackjack.domain.participant.Dealer;
import blackjack.domain.participant.Player;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String DELIMITER = ", ";

    private OutputView() {
    }

    public static void printInitHandOutCards(Dealer dealer, List<Player> players) {
        String playersNames = players.stream()
                                     .map(Player::getName)
                                     .collect(Collectors.joining(DELIMITER));
        StringBuilder sb = new StringBuilder();
        sb.append(dealer.getName())
          .append("와 ")
          .append(playersNames)
          .append("에게 2장을 나누었습니다.");
        System.out.println(sb.toString());
    }
}
