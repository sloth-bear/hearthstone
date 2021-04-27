package domain.card;

public class Dragon extends Card {

  public Dragon() {
    super(5, 12);
  }

  @Override
  public String toString() {
    return "Dragon(" + super.getPower() + "/" + super.getHp() + ")";
  }

}
