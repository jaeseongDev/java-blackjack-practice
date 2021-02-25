package blackjack.view;

import static java.util.stream.Collectors.joining;

import blackjack.domain.participant.Dealer;
import blackjack.domain.participant.Participant;
import blackjack.domain.participant.Player;
import java.util.ArrayList;
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
            printPlayerCards(player);
        }
    }

    public static void printPlayerCards(Player player) {
        String cards = parseToCards(player);
        System.out.println(player.getName() + "카드: " + cards);
    }

    private static String parseToCards(Participant participant) {
        return participant.getCards()
                          .stream()
                          .map(card -> card.getSymbol().getName() + card.getShape().getName())
                          .collect(joining(DELIMITER));
    }

    public static void printDealerReceiveAdditionalCard() {
        printEmptyLine();
        System.out.println("딜러는 16이하라 한장의 카드를 더 받았습니다.");
        printEmptyLine();
    }

    public static void printFinalCards(Dealer dealer, List<Player> players) {
        List<Participant> participants = new ArrayList<>();
        participants.add(dealer);
        participants.addAll(players);
        for (Participant participant : participants) {
            String cards = parseToCards(participant);
            System.out.println(participant.getName() + "카드: "
                + cards + " - 결과: " + participant.getCardsSum());
        }
        printEmptyLine();
    }

    public static void printResult(Dealer dealer, List<Player> players) {
        System.out.println("## 최종 승패");
        printDealerResult(dealer, players);
        printPlayersResult(dealer, players);
    }

    private static void printDealerResult(Dealer dealer, List<Player> players) {
        int dealerWinCount = 0;
        int dealerLoseCount = 0;
        for (Player player : players) {
            if (player.isWin(dealer)) {
                dealerLoseCount++;
            }
            if (!player.isWin(dealer)) {
                dealerWinCount++;
            }
        }
        System.out.println("딜러: " + dealerWinCount + "승 " + dealerLoseCount + "패");
    }

    private static void printPlayersResult(Dealer dealer, List<Player> players) {
        for (Player player : players) {
            String winOrLose = "패";
            if (player.isWin(dealer)) {
                winOrLose = "승";
            }
            System.out.println(player.getName() + ": " + winOrLose);
        }

    }

    private static void printEmptyLine() {
        System.out.println();
    }
}
