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
    return distribute(cardQuantity.getQuantity());
  }

  public List<Card> distribute(final int quantity) {
    if (CollectionUtils.isEmpty(this.cards)) {
      return Collections.emptyList();
    }

    Collections.shuffle(cards);

    return IntStream.range(0, Math.min(this.cards.size(), quantity))
            .mapToObj(cards::get)
            .collect(Collectors.toList());
  }

}
