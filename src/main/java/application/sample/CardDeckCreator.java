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
    // Sb: 만들어둔 constructor를 사용하는게 좋지 않을까요?
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
