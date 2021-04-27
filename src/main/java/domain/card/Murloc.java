package domain.card;

public class Murloc extends Card {

  public Murloc() {
    super(1, 2);
  }

  @Override
  public String toString() {
    return "Murloc(" + super.getPower() + "/" + super.getHp() + ")";
  }

}
