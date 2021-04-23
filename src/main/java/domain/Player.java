package domain;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.collections4.CollectionUtils;

public class Player {

  private int maxQuantityOfCard = 10;

  private List<Card> cards = new ArrayList<>();

  public void setMaxQuantityOfCard(final int maxQuantityOfCard) {
    this.maxQuantityOfCard = maxQuantityOfCard;
  }

  public void receive(final List<Card> cards) {
    if (CollectionUtils.size(cards) >= maxQuantityOfCard) {
      throw new IllegalArgumentException();
    }

    this.cards = cards;
  }

  public void receive(final Card card) {
    if (card == null) {
      throw new IllegalArgumentException();
    }

    if (CollectionUtils.size(this.cards) >= maxQuantityOfCard) {
      throw new IllegalStateException();
    }

    this.cards.add(card);
  }

}
