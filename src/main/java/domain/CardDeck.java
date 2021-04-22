package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import org.apache.commons.collections4.CollectionUtils;

public class CardDeck {

  private List<Card> cards;

  public CardDeck(final List<Card> cards) {
    this.cards = cards;
  }

  public List<Card> distribute(final CardQuantity cardQuantity) {
    return getRandomCards(cardQuantity.getQuantity());
  }

  public List<Card> distribute(final int quantity) {
    return getRandomCards(quantity);
  }

  private List<Card> getRandomCards(int quantity) {
    if (CollectionUtils.size(this.cards) < 1) {
      return Collections.emptyList();
    }

    int randomCardSize = this.cards.size() > quantity ? quantity : this.cards.size();

    List<Card> randomCards = new ArrayList<>(randomCardSize);
    Random random = new Random();

    for (int i = 0; i < randomCardSize; i++) {
      randomCards.add(cards.get(random.nextInt(cards.size())));
    }

    return randomCards;
  }

}
