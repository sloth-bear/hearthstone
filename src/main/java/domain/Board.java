package domain;

import java.util.List;
import org.apache.commons.collections4.CollectionUtils;

public class Board {

  private int maxQuantityOfCard = 10;

  private CardDeck cardDeck;


  public Board() {
    this.cardDeck = new CardDeck();
  }


  public void setMaxQuantityOfCard(final int maxQuantityOfCard) {
    this.maxQuantityOfCard = maxQuantityOfCard;
  }

  public void register(final List<Card> cards) {
    if (CollectionUtils.isEmpty(cards)) {
      throw new IllegalArgumentException();
    }

    if (CollectionUtils.size(cards) >= maxQuantityOfCard) {
      throw new IllegalArgumentException();
    }

    this.cardDeck.add(cards);
  }

  public void register(final Card card) {
    if (card == null) {
      throw new IllegalArgumentException();
    }

    if (this.cardDeck.getSize() >= maxQuantityOfCard) {
      throw new IllegalStateException();
    }

    this.cardDeck.add(card);
  }

}
