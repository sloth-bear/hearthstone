package domain.card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.apache.commons.collections4.CollectionUtils;

public class CardDeck {

  private int maxQuantityOfCard = 10;

  private List<Card> cards;


  public CardDeck() {
    this.cards = new ArrayList<>();
  }

  public CardDeck(final int maxQuantityOfCard) {
    this();
    this.maxQuantityOfCard = maxQuantityOfCard;
  }

  public CardDeck(final List<Card> cards) {
    this.cards = cards;
  }

  public CardDeck(final List<Card> cards, final int maxQuantityOfCard) {
    this(cards);

    this.maxQuantityOfCard = maxQuantityOfCard;
  }


  public boolean contains(final Card card) {
    return this.cards.contains(card);
  }

  public int getSize() {
    return this.cards.size();
  }

  public List<Card> distribute(final CardQuantity cardQuantity) {
    return distribute(cardQuantity.getQuantity());
  }

  public List<Card> distribute(final int quantity) {
    if (CollectionUtils.isEmpty(this.cards)) {
      return Collections.emptyList();
    }

    Collections.shuffle(cards);

    return takeOutAsManyAs(quantity);
  }

  public List<Card> takeOutAsManyAs(final int quantity) {
    if (CollectionUtils.isEmpty(this.cards)) {
      return Collections.emptyList();
    }

    return IntStream.range(0, Math.min(this.cards.size(), quantity))
        .mapToObj(this::takeOut)
        .collect(Collectors.toList());
  }

  public Card takeOut(final int cardIndex) {
    if (cardIndex < 0) {
      throw new IllegalArgumentException("제거할 카드를 다시 확인해주세요.");
    }

    try {
      Card card = this.cards.get(cardIndex);

      this.cards = this.cards.stream()
          .filter(v -> !Objects.equals(card.getId(), v.getId()))
          .collect(Collectors.toList());

      return card;
    } catch (IndexOutOfBoundsException e) {
      throw new IllegalArgumentException("제거할 카드를 다시 확인해주세요.");
    }
  }

  public void add(final List<Card> cards) {
    if (CollectionUtils.isEmpty(cards)) {
      throw new IllegalArgumentException("추가할 카드가 존재하지 않습니다.");
    }

    if (CollectionUtils.size(this.cards) >= maxQuantityOfCard) {
      throw new IllegalArgumentException();
    }

    this.cards.addAll(cards);
  }

  public void add(final Card card) {
    if (card == null) {
      throw new IllegalArgumentException("추가할 카드 정보를 올바르게 입력해주세요.");
    }

    if (CollectionUtils.size(this.cards) >= maxQuantityOfCard) {
      throw new IllegalArgumentException("더 이상 카드를 추가할 수 없습니다.");
    }

    this.cards.add(card);
  }

  public void add(final int index, final Card card) {
    if (card == null || index < 0) {
      throw new IllegalArgumentException("추가할 카드 정보를 올바르게 입력해주세요.");
    }

    if (CollectionUtils.size(this.cards) >= maxQuantityOfCard) {
      throw new IllegalArgumentException("더 이상 카드를 추가할 수 없습니다.");
    }

    this.cards.add(index, card);
  }

  @Override
  public String toString() {
    return "CardDeck { " +
        "maxQuantityOfCard=" + maxQuantityOfCard +
        ", cards=" + cards +
        " }";
  }
}
