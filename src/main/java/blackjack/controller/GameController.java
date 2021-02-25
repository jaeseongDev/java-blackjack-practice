package blackjack.controller;

import blackjack.domain.card.CardDeck;
import blackjack.domain.participant.Dealer;
import blackjack.domain.participant.Participant;
import blackjack.domain.participant.Player;
import blackjack.view.InputView;
import blackjack.view.OutputView;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GameController {

    private static final String AGREE = "y";

    public void run() {
        CardDeck cardDeck = new CardDeck();
        Dealer dealer = new Dealer();
        List<String> playersNames = InputView.inputPlayersNames();
        List<Player> players = playersNames.stream()
                                           .map(Player::new)
                                           .collect(Collectors.toList());
        List<Participant> participants = createParticipants(players, dealer);
        initCardHandout(participants, cardDeck);
        OutputView.printInitHandOutCards(dealer, players);
        OutputView.printDealerCards(dealer);
        OutputView.printPlayersCards(players);
        for (Player player : players) {
            String answer;
            do {
                answer = InputView.inputIfReceiveCard(player);
                if (answer.equals(AGREE)) {
                    player.receive(cardDeck.handoutOneCard());
                }
            } while (answer.equals(AGREE));
            OutputView.printPlayerCards(player);
        }
    }

    private List<Participant> createParticipants(List<Player> players, Dealer dealer) {
        List<Participant> participants = new ArrayList<>();
        participants.add(dealer);
        participants.addAll(players);
        return participants;
    }

    private void initCardHandout(List<Participant> participants, CardDeck cardDeck) {
        for (Participant participant : participants) {
            participant.receive(cardDeck.handoutTwoCards());
        }
    }
}
