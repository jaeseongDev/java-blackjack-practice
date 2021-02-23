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
    private static final int ONE_CARD_SIZE = 1;
    private static final int NO_CARD = 0;
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
        return handoutCards(TWO_CARDS_SIZE);
    }

    public List<Card> handoutOneCard() {
        return handoutCards(ONE_CARD_SIZE);
    }

    private List<Card> handoutCards(int cardsSize) {
        List<Card> cards = new ArrayList<>();
        for (int i = 0; i < cardsSize; i++) {
            if (cardDeck.size() == NO_CARD) {
                cardDeck = createShuffledCardDeck();
            }
            int lastIndex = cardDeck.size() - GAP_WITH_INDEX_AND_SIZE;
            cards.add(cardDeck.remove(lastIndex));
        }
        return cards;
    }
}