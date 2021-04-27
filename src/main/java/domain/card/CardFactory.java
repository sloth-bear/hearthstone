package domain.card;

import java.util.List;

public class CardFactory {

  private CardFactory() {
    throw new UnsupportedOperationException();
  }

  public static List<Card> getSample() {
    return List.of(
        new Dragon(), new Dragon(), new Dragon(), new Dragon(),
        new Murloc(), new Murloc(), new Murloc(), new Murloc(),
        new Teacher(), new Teacher(), new Teacher(), new Teacher(),
        new Zombie(), new Zombie(), new Zombie()
    );
  }

}
