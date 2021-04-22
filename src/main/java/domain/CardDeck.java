package domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
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

    int randomCardSize = Math.min(this.cards.size(), quantity);

    Collections.shuffle(cards);

    return IntStream.range(0, randomCardSize)
        .mapToObj(cards::get)
        .collect(Collectors.toList());
  }

}
