package domain.card;

public enum CardQuantity {

  PREEMPTIVE_ATTACK(3),
  NON_PREEMPTIVE_ATTACK(4);

  int quantity;

  CardQuantity(final int quantity) {
    this.quantity = quantity;
  }

  public int getQuantity() {
    return quantity;
  }
}
