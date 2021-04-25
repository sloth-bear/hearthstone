package domain;

import org.apache.commons.collections4.CollectionUtils;

import java.util.List;

public class Player {

  private final Hero hero;
  private final CardDeck cardDeck;

  private final Board board;

  public Player(final Hero hero, final CardDeck cardDeck, final Board board) {
    this.hero = hero;
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

  public void attack(final Card attacker, final Card victim) {
    if (this.cardDeck == null || this.cardDeck.isEmpty()) {
      throw new IllegalStateException("꺼낼 수 있는 카드가 없습니다.");
    }

    if (this.cardDeck.contains(attacker)) {
      throw new IllegalStateException("존재하지 않는 카드입니다.");
    }

    victim.beDamaged(attacker.getPower());
  }

  public void attack(final Card attacker) {
    if (this.cardDeck == null || this.cardDeck.isEmpty()) {
      throw new IllegalStateException("꺼낼 수 있는 카드가 없습니다.");
    }

    if (this.cardDeck.contains(attacker)) {
      throw new IllegalStateException("존재하지 않는 카드입니다.");
    }

    this.hero.beDamaged(attacker.getPower());
  }

}
