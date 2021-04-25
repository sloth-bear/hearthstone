package domain;

import java.util.List;
import org.apache.commons.collections4.CollectionUtils;

public class Board {

  private int maxQuantityOfCard = 10;

  private List<Card> cards;

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

    this.cards.addAll(cards);
  }

  public void register(final Card card) {
    if (card == null) {
      throw new IllegalArgumentException();
    }

    if (CollectionUtils.size(this.cards) >= maxQuantityOfCard) {
      throw new IllegalStateException();
    }

    this.cards.add(card);
  }

}
