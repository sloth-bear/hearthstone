package application.sample;

import static util.MessageWriter.info;

import domain.card.*;
import java.util.List;

public class CardDeckCreator {

  private CardDeckCreator () {
    throw new UnsupportedOperationException();
  }

  public static CardDeck create() {
    CardDeck cardDeck = new CardDeck();
    cardDeck.add(
        List.of(
            new Dragon(), new Dragon(), new Dragon(), new Dragon(),
            new Murloc(), new Murloc(), new Murloc(), new Murloc(),
            new Teacher(), new Teacher(), new Teacher(), new Teacher(),
            new Zombie(), new Zombie(), new Zombie()
        )
    );

    info("카드덱이 생성되었습니다.", cardDeck);

    return cardDeck;
  }

}
