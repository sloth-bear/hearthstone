package domain.card;

public class Teacher extends Card {

  public Teacher() {
    super(3, 5);
  }

  @Override
  public String toString() {
    return "Teacher(" + super.getPower() + "/" + super.getHp() + ")";
  }

}
