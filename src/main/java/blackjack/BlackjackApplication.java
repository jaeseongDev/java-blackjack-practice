package blackjack;

import blackjack.controller.GameController;

public class BlackjackApplication {

    public static void main(String[] args) {
        GameController gameController = new GameController();
        gameController.run();
    }
}
