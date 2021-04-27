package domain;


import domain.card.Card;
import domain.card.CardDeck;
import domain.hero.Hero;
import java.util.List;

public class Player {

  private final Hero hero;
  private final CardDeck cardDeck;
  private final Board board;


  public Player(Hero hero) {
    this.hero = hero;
    this.cardDeck = new CardDeck();
    this.board = new Board();
  }


  public Hero getHero() {
    return this.hero;
  }

  public CardDeck getCardDeck() {
    return cardDeck;
  }

  public Board getBoard() {
    return board;
  }

  public void receive(final List<Card> cards) {
    this.cardDeck.add(cards);
  }

  public void receive(final Card card) {
    this.cardDeck.add(card);
  }

  public void resister(final int indexOfDeck, final int indexOfBoard) {
    Card card = this.cardDeck.takeOut(indexOfDeck);
    this.board.register(indexOfBoard, card);
  }

  public void attack(final int indexOfDeck, final Hero victim) {
    Card attacker = this.cardDeck.takeOut(indexOfDeck);
    attacker.attack(victim);
  }

  public void attack(final Hero victim) {
    this.hero.attack(victim);
  }

  @Override
  public String toString() {
    return "Player { " +
        "hero=" + hero +
        ", cardDeck=" + cardDeck +
        ", board=" + board +
        " }";
  }
}
