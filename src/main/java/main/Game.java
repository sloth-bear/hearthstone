package main;

import static printer.Printer.printInformationLine;
import static printer.Printer.printSeparateLine;

import domain.Player;
import domain.card.*;
import domain.hero.Warrior;
import domain.hero.Wizard;
import java.util.List;
import java.util.Scanner;

public class Game {

  public void play() {
    printSeparateLine("게임이 시작됩니다.");

    CardDeck cardDeck = new CardDeck();
    cardDeck.add(getSample());

    printSeparateLine("카드덱이 생성되었습니다.");
    printSeparateLine(cardDeck.toString());

    Player wizard = new Player(new Wizard());
    Player warrior = new Player(new Warrior());

    printSeparateLine("플레이어가 생성되었습니다.");
    printInformationLine("[Wizard]", wizard);
    printInformationLine("[Warrior]", warrior);

    cardDeck.distribute(CardQuantity.PREEMPTIVE_ATTACK, wizard);
    cardDeck.distribute(CardQuantity.NON_PREEMPTIVE_ATTACK, warrior);

    printSeparateLine("카드덱을 분배합니다.");
    printInformationLine("[Wizard] 카드덱: ", wizard.getCardDeck());
    printInformationLine("[Warrior] 카드덱: ", warrior.getCardDeck());
    printInformationLine("남은 카드덱: ", cardDeck);

    Scanner scanner = new Scanner(System.in);

    while (wizard.getHero().getHp() > 0 && warrior.getHero().getHp() > 0) {
      printSeparateLine("카드를 등록하시려면 1번, 공격하시려면 2번을 눌러주세요.");

      if (scanner.nextInt() == 1) {
        register(wizard, scanner);
        register(warrior, scanner);
      } else {
        attack(wizard, warrior, scanner);
        attack(warrior, wizard, scanner);
      }
    }

    scanner.close();

    printSeparateLine(wizard.getHero().getHp() < 1 ? "Warrior의 승리입니다." : "Wizard의 승리입니다.");
    printInformationLine("[Wizard]", wizard);
    printInformationLine("[Warrior]", warrior);
  }

  private void register(final Player player, final Scanner scanner) {
    printSeparateLine("몇 번째 카드를 등록하시겠습니까?");

    int indexOfDeck = scanner.nextInt();
    printSeparateLine("등록할 위치를 입력해주세요.");
    printInformationLine("[게임보드]", player.getBoard());

    int indexOfBoard = scanner.nextInt();

    try {
      player.resister(indexOfDeck, indexOfBoard);

      printInformationLine("등록되었습니다", player.getBoard());
    } catch (IllegalStateException | IllegalArgumentException | IndexOutOfBoundsException e) {
      printSeparateLine("정확한 값을 입력해주세요.");

      register(player, scanner);
    }
  }

  private void attack(final Player attacker, final Player victim, final Scanner scanner) {
    printSeparateLine("영웅으로 직접 공격하시려면 1번, 카드로 공격하시려면 2번을 눌러주세요. 단, 영웅으로 공격할 시 영웅의 체력이 닳습니다.");

    if (scanner.nextInt() == 1) {
      attacker.attack(victim.getHero());

      printSeparateLine("공격하였습니다.");

      printSeparateLine("플레이어 정보입니다.");
      printInformationLine("[공격자]", attacker);
      printInformationLine("[방어자]", victim);
    } else {
      attackWithCard(attacker, victim, scanner);
    }
  }

  private void attackWithCard(final Player attacker, final Player victim, final Scanner scanner) {
    printSeparateLine("몇 번째 카드로 공격하시겠습니까?");
    printInformationLine("[소유 카드덱]", attacker.getCardDeck());

    try {
      attacker.attack(scanner.nextInt(), victim.getHero());

      printSeparateLine("공격하였습니다.");

      printSeparateLine("플레이어 정보입니다.");
      printInformationLine("[공격자]", attacker);
      printInformationLine("[방어자]", victim);
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
