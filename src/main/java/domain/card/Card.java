package domain.card;

import domain.hero.Hero;
import java.util.UUID;

public class Card {

  private final UUID id;

  private int power;
  private int hp;

  public Card(final int power, final int hp) {
    this.id = UUID.randomUUID();
    this.power = power;
    this.hp = hp;
  }

  public UUID getId() {
    return this.id;
  }

  public int getPower() {
    return this.power;
  }

  public int getHp() {
    return this.hp;
  }

  public void attack(final Card victim) {
    if (victim == null) {
      throw new IllegalArgumentException("공격받을 대상이 존재하지 않습니다.");
    }

    victim.beDamaged(getPower());
  }

  public void attack(final Hero victim) {
    if (victim == null) {
      throw new IllegalArgumentException("공격받을 대상이 존재하지 않습니다.");
    }

    victim.beDamaged(getPower());
  }

  public void beDamaged(final int power) {
    this.hp = this.hp - power;
  }

  @Override
  public String toString() {
    return "Card(" + power + "/" + hp + ")";
  }

}
