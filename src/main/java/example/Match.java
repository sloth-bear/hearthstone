package example;

import domain.Player;
import domain.card.*;
import domain.hero.Warrior;
import domain.hero.Wizard;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Match {

  public void start () {
    MessageWriter.info("1:1 매치를 시작합니다.");

    CardDeck cardDeck = createCardDeck();
    Map<AttackOrder, Player> players = createPlayers();

    distributeCards(cardDeck, players);

    Scanner scanner = new Scanner(System.in);

    while (isAllActive(players)) {
      start(players, scanner);
    }

    MessageWriter.info("매치가 종료되었습니다.");
    MessageWriter.info(getWinner(players).getHero().toString() + "의 승리입니다.");
  }

  private void start(final Map<AttackOrder, Player> players, final Scanner scanner) {
    for (var key : players.keySet()) {
      Player attacker = players.get(key);
      Player victim = players.get(AttackOrder.getOppositeOrder(key));

      MessageWriter.info(attacker.getHero().toString() + " 턴입니다.");
      MessageWriter.info("공격하려면 1번, 카드를 등록하려면 2번을 눌러주세요.");

      if (scanner.nextInt() == 1) {
        attack(attacker, victim, scanner);
      } else {
        register(attacker, scanner);
      }

      if (attacker.isInactive()) {
        return;
      }
    }
  }

  private void register(final Player player, final Scanner scanner) {
    MessageWriter.info("몇 번째 카드를 등록하시겠습니까? 카드는 0번부터 시작합니다.", player.getCardDeck());

    int indexOfDeck = scanner.nextInt();

    MessageWriter.info("등록할 위치를 입력해주세요. 위치는 0번부터 시작합니다.", player.getBoard());

    int indexOfBoard = scanner.nextInt();

    try {
      player.resister(indexOfDeck, indexOfBoard);

      MessageWriter.info("등록되었습니다.", player.getBoard());
    } catch (IllegalStateException | IllegalArgumentException | IndexOutOfBoundsException e) {
      MessageWriter.error("정확한 위치를 입력해주세요.");

      register(player, scanner);
    }
  }

  private void attack(final Player attacker, final Player victim, final Scanner scanner) {
    MessageWriter.info("영웅으로 직접 공격하시려면 1번, 카드로 공격하시려면 2번을 눌러주세요.");

    if (scanner.nextInt() == 1) {
      attacker.attack(victim.getHero());
    } else {
      MessageWriter.info("몇 번 카드로 선택하시겠습니까? 카드는 0번부터 시작합니다.", attacker.getCardDeck());

      attacker.attack(scanner.nextInt(), victim.getHero());

      MessageWriter.info("공격하였습니다.", attacker);
      MessageWriter.info("상대방의 체력은 다음과 같습니다.", victim.getHero());
    }
  }

  private void distributeCards(final CardDeck cardDeck, final Map<AttackOrder, Player> players) {
    for (var key : players.keySet()) {
      cardDeck.distribute(key, players.get(key));
    }

    MessageWriter.info("카드가 분배되었습니다.");
  }

  private Map<AttackOrder, Player> createPlayers() {
    Map<AttackOrder, Player> players = new LinkedHashMap<>();
    players.put(AttackOrder.PREEMPTIVE_ATTACK, new Player(new Warrior()));
    players.put(AttackOrder.NON_PREEMPTIVE_ATTACK, new Player(new Wizard()));

    MessageWriter.info("플레이어가 생성되었습니다.", players);

    return players;
  }

  private Player getWinner(final Map<AttackOrder, Player> players) {
    return players.keySet().stream()
        .filter(key -> !players.get(key).isInactive())
        .map(players::get)
        .findFirst()
        .orElse(null);
  }

  private boolean isAllActive(final Map<AttackOrder, Player> players) {
    return players.keySet().stream().noneMatch(key -> players.get(key).isInactive());
  }

  private CardDeck createCardDeck() {
    CardDeck cardDeck = new CardDeck();
    cardDeck.add(
        List.of(
            new Dragon(), new Dragon(), new Dragon(), new Dragon(),
            new Murloc(), new Murloc(), new Murloc(), new Murloc(),
            new Teacher(), new Teacher(), new Teacher(), new Teacher(),
            new Zombie(), new Zombie(), new Zombie()
        )
    );

    MessageWriter.info("카드덱이 생성되었습니다.", cardDeck);

    return cardDeck;
  }

}
