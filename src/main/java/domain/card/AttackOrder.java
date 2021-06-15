package domain.card;

public enum AttackOrder {

  PREEMPTIVE_ATTACK(3),
  NON_PREEMPTIVE_ATTACK(4);

  int cardQuantity;

  AttackOrder(final int cardQuantity) {
    this.cardQuantity = cardQuantity;
  }

  public int getCardQuantity() {
    return cardQuantity;
  }


  // Sb: 생각해보세요
  public static AttackOrder getOppositeOrder(final AttackOrder attackOrder) {
    return attackOrder == PREEMPTIVE_ATTACK ? NON_PREEMPTIVE_ATTACK : PREEMPTIVE_ATTACK;
  }
}
