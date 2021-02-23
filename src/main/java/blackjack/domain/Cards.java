package blackjack.domain;

import blackjack.domain.card.Card;
import blackjack.domain.card.Shape;
import blackjack.domain.card.Symbol;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Cards {
    public static List<Card> cards = new ArrayList<>(createShuffledCardDeck());

    public Cards() {
    }

    private static List<Card> createShuffledCardDeck() {
        List<Card> cards = new ArrayList<>();
        for (Shape shape : Shape.values()) {
            for (Symbol symbol : Symbol.values()) {
                cards.add(new Card(shape, symbol));
            }
        }
        Collections.shuffle(cards);
        return cards;
    }

    public boolean contains(Card card) {
        return cards.contains(card);
    }


}