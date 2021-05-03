package application;

import static util.MessageWriter.info;
import static util.MessageWriter.error;

import domain.Player;
import domain.card.*;
import java.util.Map;
import java.util.Scanner;

public class Match {

  private Map<AttackOrder, Player> players;

  public Match(final Map<AttackOrder, Player> players) {
    this.players = players;
  }

  public void start() {
    info("경기를 시작합니다.");

    Scanner scanner = new Scanner(System.in);

    while (isAllActive(players)) {
      start(scanner);
    }

    info("매치가 종료되었습니다.");
    info(getWinner(players).getHero().toString() + "의 승리입니다.");
  }

  private void start(final Scanner scanner) {
    for (var key : players.keySet()) {
      Player attacker = players.get(key);
      Player victim = players.get(AttackOrder.getOppositeOrder(key));

      info(attacker.getHero().toString() + " 턴입니다.");
      info("공격하려면 1번, 카드를 등록하려면 2번을 눌러주세요.");

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
    info("몇 번째 카드를 등록하시겠습니까? 카드는 0번부터 시작합니다.", player.getCardDeck());

    int indexOfDeck = scanner.nextInt();

    info("등록할 위치를 입력해주세요. 위치는 0번부터 시작합니다.", player.getBoard());

    int indexOfBoard = scanner.nextInt();

    try {
      player.resister(indexOfDeck, indexOfBoard);

      info("등록되었습니다.", player.getBoard());
    } catch (IllegalStateException | IllegalArgumentException | IndexOutOfBoundsException e) {
      error("정확한 위치를 입력해주세요.");

      register(player, scanner);
    }
  }

  private void attack(final Player attacker, final Player victim, final Scanner scanner) {
    info("영웅으로 직접 공격하시려면 1번, 카드로 공격하시려면 2번을 눌러주세요.");

    if (scanner.nextInt() == 1) {
      attacker.attack(victim.getHero());

      return;
    }

    info("몇 번 카드로 선택하시겠습니까? 카드는 0번부터 시작합니다.", attacker.getCardDeck());

    attacker.attack(scanner.nextInt(), victim.getHero());

    info("공격하였습니다.", attacker);
    info("상대방의 체력은 다음과 같습니다.", victim.getHero());
  }

  private Player getWinner(final Map<AttackOrder, Player> players) {
    return players.keySet().stream()
        .filter(key -> !players.get(key).isInactive())
        .map(players::get)
        .findFirst()
        .orElseThrow(() -> new UnsupportedOperationException("승자가 존재하지 않습니다."));
  }

  private boolean isAllActive(final Map<AttackOrder, Player> players) {
    return players.keySet().stream().noneMatch(key -> players.get(key).isInactive());
  }

}
