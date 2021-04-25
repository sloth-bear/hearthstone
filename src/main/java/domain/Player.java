package domain;

import org.apache.commons.collections4.CollectionUtils;

import java.util.List;

public class Player {

  private final CardDeck cardDeck;
  private final Board board;

  public Player(final CardDeck cardDeck, final Board board) {
    this.cardDeck = cardDeck;
    this.board = board;
  }

  public void receive(final List<Card> cards) {
    if (CollectionUtils.isEmpty(cards)) {
      throw new IllegalArgumentException();
    }

    this.cardDeck.add(cards);
  }

  public void receive(final Card card) {
    if (card == null) {
      throw new IllegalArgumentException();
    }

    this.cardDeck.add(card);
  }

  public void resister(final Card card) {
    if (this.cardDeck == null || this.cardDeck.isEmpty()) {
      throw new IllegalStateException("등록할 수 있는 카드가 없습니다.");
    }

    if (this.cardDeck.contains(card)) {
      throw new IllegalStateException("존재하지 않는 카드입니다.");
    }

    this.cardDeck.remove(card);
    this.board.register(card);
  }

}
