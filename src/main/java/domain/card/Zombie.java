package domain.card;

public class Zombie extends Card {

  public Zombie() {
    super(6, 7);
  }

  @Override
  public String toString() {
    return "Zombie(" + super.getPower() + "/" + super.getHp() + ")";
  }

}
