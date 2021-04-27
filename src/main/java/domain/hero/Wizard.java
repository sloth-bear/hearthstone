package domain.hero;

public class Wizard extends Hero {

  public Wizard() {
    super(2);
  }

  @Override
  public String toString() {
    return "Wizard(" + this.getPower() + "/" + this.getHp() + ")";
  }

}
