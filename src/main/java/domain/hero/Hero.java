package domain.hero;

import java.util.UUID;

public class Hero {

  private final UUID id;

  private int hp = 30;
  private int power;

  public Hero(final int power) {
    this.id = UUID.randomUUID();
    this.power = power;
  }

  public UUID getId() {
    return this.id;
  }

  public void beDamaged(final int power) {
    this.hp = this.hp - power;
  }

}
