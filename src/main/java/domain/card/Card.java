package domain.card;

import java.util.UUID;

public class Card {

  private final UUID id;

  private Species species;

  private int power;
  private int hp;

  public Card(final Species species, final int power, final int hp) {
    this.id = UUID.randomUUID();
    this.species = species;
    this.power = power;
    this.hp = hp;
  }

  public UUID getId() {
    return this.id;
  }

  public int getPower() {
    return this.power;
  }

  public void beDamaged(final int power) {
    this.hp = this.hp - power;
  }

}
