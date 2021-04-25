package domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.apache.commons.collections4.CollectionUtils;

public class CardDeck {

  private int maxQuantityOfCard = 10;

  private List<Card> cards;

  public CardDeck(final List<Card> cards) {
    this.cards = cards;
  }

  public CardDeck(final List<Card> cards, final int maxQuantityOfCard) {
    this.cards = cards;
    this.maxQuantityOfCard = maxQuantityOfCard;
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

  public void add(final List<Card> card) {
    if (card == null) {
      throw new IllegalArgumentException("추가할 카드가 존재하지 않습니다.");
    }

    if (CollectionUtils.size(this.cards) >= maxQuantityOfCard) {
      throw new IllegalArgumentException();
    }

    this.cards.addAll(card);
  }

  public void add(final Card card) {
    if (card == null) {
      throw new IllegalArgumentException("추가할 카드가 존재하지 않습니다.");
    }

    if (CollectionUtils.size(this.cards) >= maxQuantityOfCard) {
      throw new IllegalArgumentException("더 이상 카드를 추가할 수 없습니다.");
    }

    this.cards.add(card);
  }

  public void remove(final Card card) {
    if (card == null) {
      throw new IllegalArgumentException("제거할 카드가 존재하지 않습니다.");
    }

    this.cards = this.cards.stream()
        .filter(v -> Objects.equals(card.getId(), v.getId()))
        .collect(Collectors.toList());
  }

  public boolean isEmpty() {
    return CollectionUtils.isEmpty(this.cards);
  }

  public boolean contains(final Card card) {
    return this.cards.contains(card);
  }

}
