package domain;

public enum AttackOrder {

  FIRST(3),
  SECOND(4);

  int cardQuantity;

  AttackOrder(final int cardQuantity) {
    this.cardQuantity = cardQuantity;
  }

  public int getCardQuantity() {
    return cardQuantity;
  }
}
