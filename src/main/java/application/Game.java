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

    // Sb:  player creator인데 return은 map이에요
    Map<AttackOrder, Player> players = PlayerCreator.create();

    // Sb: 플레이어가 다 카드를 쥐고있지 않나요?
    CardHolder cardHolder = new CardHolder(CardDeckCreator.create());
    cardHolder.distribute(players);

    Match match = new Match(players);
    match.start();

    info("게임이 종료됩니다.");
  }

}
