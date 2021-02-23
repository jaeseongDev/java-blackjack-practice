package blackjack.domain;

import blackjack.domain.card.Card;
import blackjack.domain.card.Shape;
import blackjack.domain.card.Symbol;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardDeck {

    private static final int GAP_WITH_INDEX_AND_SIZE = 1;
    private static final int TWO_CARDS_SIZE = 2;
    public static List<Card> cardDeck = new ArrayList<>(createShuffledCardDeck());

    public CardDeck() {
    }

    private static List<Card> createShuffledCardDeck() {
        List<Card> cardDeck = new ArrayList<>();
        for (Shape shape : Shape.values()) {
            for (Symbol symbol : Symbol.values()) {
                cardDeck.add(new Card(shape, symbol));
            }
        }
        Collections.shuffle(cardDeck);
        return cardDeck;
    }

    public boolean contains(Card card) {
        return cardDeck.contains(card);
    }

    public List<Card> handoutTwoCards() {
        List<Card> cards = new ArrayList<>();
        for (int i = 0; i < TWO_CARDS_SIZE; i++) {
            int lastIndex = cardDeck.size() - GAP_WITH_INDEX_AND_SIZE;
            cards.add(cardDeck.remove(lastIndex));
        }
        return cards;
    }
}