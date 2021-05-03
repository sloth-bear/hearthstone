package application;

import static util.MessageWriter.info;

import application.sample.CardDeckCreator;
import application.sample.PlayerCreator;
import domain.Player;
import domain.card.AttackOrder;
import java.util.Map;

public class Game {

  public void play() {
    info("게임을 시작합니다.");

    Map<AttackOrder, Player> players = PlayerCreator.create();
    CardHolder cardHolder = new CardHolder(CardDeckCreator.create());

    cardHolder.distribute(players);

    Match match = new Match(players);
    match.start();

    info("게임이 종료됩니다.");
  }

}
