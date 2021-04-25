package domain;

public class Card {

  private String id;
  private Species species;

  public Card(final Species species) {
    this.species = species;
  }

  public String getId() {
    return this.id;
  }

}
