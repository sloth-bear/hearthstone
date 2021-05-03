package application.sample;

import static util.MessageWriter.info;

import domain.Player;
import domain.card.AttackOrder;
import domain.hero.Warrior;
import domain.hero.Wizard;
import java.util.LinkedHashMap;
import java.util.Map;

public class PlayerCreator {

  private PlayerCreator() {
    throw new UnsupportedOperationException();
  }

  public static Map<AttackOrder, Player> create() {
    Map<AttackOrder, Player> players = new LinkedHashMap<>();
    players.put(AttackOrder.PREEMPTIVE_ATTACK, new Player(new Warrior()));
    players.put(AttackOrder.NON_PREEMPTIVE_ATTACK, new Player(new Wizard()));

    info("플레이어가 생성되었습니다.", players);

    return players;
  }

}
