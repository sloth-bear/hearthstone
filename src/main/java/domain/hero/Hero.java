package domain.hero;

import java.util.UUID;

public class Hero {

  private final UUID id;

  private Species species;

  private int power;

  private int hp = 30;
  private boolean dead = false;

  public Hero(final Species species, final int power) {
    this.id = UUID.randomUUID();
    this.species = species;
    this.power = power;
  }

  public UUID getId() {
    return this.id;
  }

  public int getPower() {
    return this.power;
  }

  public boolean isDead() {
    return this.dead;
  }

  public void beDamaged(final int power) {
    this.hp = this.hp - power;

    if (this.hp < 1) {
      this.dead = true;
    }
  }

}
