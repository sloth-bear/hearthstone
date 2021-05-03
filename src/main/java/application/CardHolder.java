package application;

import static util.MessageWriter.info;

import domain.Player;
import domain.card.AttackOrder;
import domain.card.CardDeck;
import java.util.Map;

public class CardHolder {

  private CardDeck cardDeck;

  public CardHolder(final CardDeck cardDeck) {
    this.cardDeck = cardDeck;
  }

  public void distribute(final Map<AttackOrder, Player> players) {
    for (var key : players.keySet()) {
      this.cardDeck.distribute(key, players.get(key));
    }

    info("카드가 분배되었습니다.");
  }

}
