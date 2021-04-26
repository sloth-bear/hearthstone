package domain;


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
    this.cardDeck.add(cards);
  }

  public void receive(final Card card) {
    this.cardDeck.add(card);
  }

  public void resister(final int indexOfDeck, final int indexOfBoard) {
    if (this.cardDeck == null) {
      throw new IllegalStateException("카드덱이 존재하지 않습니다.");
    }

    Card card = this.cardDeck.takeOut(indexOfDeck);
    this.board.register(indexOfBoard, card);
  }

  public void attack(final int indexOfDeck, final Card victim) {
    if (victim == null) {
      throw new IllegalArgumentException("공격받을 대상이 존재하지 않습니다.");
    }

    if (this.cardDeck == null) {
      throw new IllegalStateException("카드덱이 존재하지 않습니다.");
    }

    Card attacker = this.cardDeck.takeOut(indexOfDeck);
    victim.beDamaged(attacker.getPower());
  }

  public void attack(final int indexOfDeck, final Hero victim) {
    if (victim == null) {
      throw new IllegalArgumentException("공격받을 대상이 존재하지 않습니다.");
    }

    if (this.cardDeck == null) {
      throw new IllegalStateException("꺼낼 수 있는 카드가 없습니다.");
    }

    Card attacker = this.cardDeck.takeOut(indexOfDeck);
    victim.beDamaged(attacker.getPower());
  }

  public void attack(final Card victim) {
    victim.beDamaged(this.hero.getPower());
  }

  public void attack(final Hero victim) {
    victim.beDamaged(this.hero.getPower());
  }

}
