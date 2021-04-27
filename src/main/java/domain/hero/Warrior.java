package domain.hero;

public class Warrior extends Hero {

  public Warrior() {
    super(2);
  }

  @Override
  public String toString() {
    return "Warrior(" + this.getPower() + "/" + this.getHp() + ")";
  }

}
