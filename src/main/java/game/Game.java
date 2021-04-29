package game;

import static printer.Printer.print;
import static printer.Printer.println;
import static printer.Printer.printDivider;

import domain.Player;
import domain.card.*;
import domain.hero.Warrior;
import domain.hero.Wizard;
import java.util.List;
import java.util.Scanner;

public class Game {

  public void play() {
    printDivider();

    print("게임이 시작됩니다.");

    CardDeck cardDeck = new CardDeck();
    cardDeck.add(getSample());

    printDivider();
    println("카드덱이 생성되었습니다.", cardDeck);

    Player wizard = new Player(new Wizard());
    Player warrior = new Player(new Warrior());

    printDivider();

    print("플레이어 정보입니다.");
    print("[선공]", wizard);
    print("[후공]", warrior);

    distributeCards(cardDeck, wizard, warrior);

    Scanner scanner = new Scanner(System.in);

    while (wizard.getHero().getHp() > 0 && warrior.getHero().getHp() > 0) {
      print("카드를 등록하시려면 1번, 공격하시려면 2번을 눌러주세요.");

      if (scanner.nextInt() == 1) {
        register(wizard, scanner);
        register(warrior, scanner);
      } else {
        attack(wizard, warrior, scanner);
        attack(warrior, wizard, scanner);
      }
    }

    scanner.close();

    printDivider();

    print(wizard.getHero().getHp() < 1 ? "[선공]의 승리입니다." : "[후공]의 승리입니다.");
    print(wizard.getHero(), wizard);
    print(warrior.getHero(), warrior);

    printDivider();

    print("게임이 종료되었습니다.");
  }

  private void distributeCards(final CardDeck cardDeck, final Player attacker, final Player victim) {
    printDivider();

    print("카드덱을 분배합니다.");

    cardDeck.distribute(CardQuantity.PREEMPTIVE_ATTACK, attacker);
    cardDeck.distribute(CardQuantity.NON_PREEMPTIVE_ATTACK, victim);

    print("[Wizard]", attacker.getCardDeck());
    print("[Warrior]", victim.getCardDeck());

    printDivider();

    print("남은 카드덱 정보입니다.");
    print("[카드덱]", cardDeck);

    printDivider();
  }

  private void register(final Player player, final Scanner scanner) {
    print("몇 번째 카드를 등록하시겠습니까?");

    int indexOfDeck = scanner.nextInt();
    print("등록할 위치를 입력해주세요.");
    print("[게임보드]", player.getBoard());

    int indexOfBoard = scanner.nextInt();

    try {
      player.resister(indexOfDeck, indexOfBoard);

      print("등록되었습니다", player.getBoard());
      printDivider();
    } catch (IllegalStateException | IllegalArgumentException | IndexOutOfBoundsException e) {
      print("정확한 값을 입력해주세요.");

      register(player, scanner);

      printDivider();
    }
  }

  private void attack(final Player attacker, final Player victim, final Scanner scanner) {
    print(attacker.getHero(), "영웅으로 직접 공격하시려면 1번, 카드로 공격하시려면 2번을 눌러주세요. 단, 영웅으로 공격할 시 영웅의 체력이 닳습니다.");

    if (scanner.nextInt() == 1) {
      attacker.attack(victim.getHero());

      print("공격하였습니다.");

      printDivider();

      print("플레이어 정보입니다.");
      print(attacker.getHero(), attacker);
      print(victim.getHero(), victim);

      printDivider();
    } else {
      attackWithCard(attacker, victim, scanner);
    }
  }

  private void attackWithCard(final Player attacker, final Player victim, final Scanner scanner) {
    print("몇 번째 카드로 공격하시겠습니까?");
    print("[소유 카드덱]", attacker.getCardDeck());

    try {
      attacker.attack(scanner.nextInt(), victim.getHero());

      print("공격하였습니다.");

      printDivider();

      print("플레이어 정보입니다.");
      print(attacker.getHero(), attacker);
      print(victim.getHero(), victim);

      printDivider();
    } catch (IllegalStateException | IllegalArgumentException e) {
      attackWithCard(attacker, victim, scanner);
    }
  }

  private List<Card> getSample() {
    return List.of(
        new Dragon(), new Dragon(), new Dragon(), new Dragon(),
        new Murloc(), new Murloc(), new Murloc(), new Murloc(),
        new Teacher(), new Teacher(), new Teacher(), new Teacher(),
        new Zombie(), new Zombie(), new Zombie()
    );
  }

}
