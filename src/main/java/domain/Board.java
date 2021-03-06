package domain;

import domain.card.Card;
import domain.card.CardDeck;
import java.util.List;

public class Board {

  private CardDeck cardDeck;

  public Board() {
    this.cardDeck = new CardDeck();
  }

  public void register(final List<Card> cards) {
    this.cardDeck.add(cards);
  }

  public void register(final int index, final Card card) {
    this.cardDeck.add(index, card);
  }

  @Override
  public String toString() {
    return cardDeck.toString();
  }

}
