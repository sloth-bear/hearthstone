package domain.hero;

import domain.card.Card;
import java.util.UUID;

public class Hero {

  private final UUID id;

  private int hp = 15;
  private int power;

  public Hero(final int power) {
    this.id = UUID.randomUUID();
    this.power = power;
  }

  public UUID getId() {
    return this.id;
  }

  public int getPower() {
    return power;
  }

  public void attack(final Card victim) {
    if (victim == null) {
      throw new IllegalArgumentException("공격받을 대상이 존재하지 않습니다.");
    }

    victim.beDamaged(getPower());
    this.beDamaged(victim.getPower());
  }

  public void attack(final Hero victim) {
    if (victim == null) {
      throw new IllegalArgumentException("공격받을 대상이 존재하지 않습니다.");
    }

    victim.beDamaged(getPower());
    this.beDamaged(victim.getPower());
  }

  public void beDamaged(final int power) {
    this.hp = this.hp - power;
  }

  @Override
  public String toString() {
    return "Hero { " +
        "hp=" + hp +
        ", power=" + power +
        " }";
  }
}
