package main;

import domain.Board;
import domain.Player;
import domain.card.*;
import domain.hero.Warrior;
import domain.hero.Wizard;
import java.util.List;
import java.util.Scanner;

public class Application {

  public static void main(String[] args) {
    System.out.printf(":: 게임이 시작됩니다. ::%n%n");

    CardDeck cardDeck = new CardDeck(15);
    cardDeck.add(
        List.of(new Dragon(), new Dragon(), new Dragon(), new Dragon(),
            new Murloc(), new Murloc(), new Murloc(), new Murloc(),
            new Teacher(), new Teacher(), new Teacher(), new Teacher(),
            new Zombie(), new Zombie(), new Zombie()));

    System.out.printf(":: 카드덱이 생성되었습니다. :: %n%s%n%n", cardDeck);

    Player wizard = new Player(new Wizard(), new CardDeck(), new Board());
    Player warrior = new Player(new Warrior(), new CardDeck(), new Board());

    System.out.printf(":: 플레이어가 생성되었습니다. :: %n%s%n%s%n%n", wizard, warrior);

    wizard.receive(cardDeck.distribute(CardQuantity.PREEMPTIVE_ATTACK));
    warrior.receive(cardDeck.distribute(CardQuantity.NON_PREEMPTIVE_ATTACK));

    System.out.println(":: 카드덱을 분배합니다. ::");
    System.out.printf("[Wizard] 카드덱:  %s%n", wizard.getCardDeck());
    System.out.printf("[Warrior] 카드덱: %s%n", warrior.getCardDeck());
    System.out.printf("남은 카드덱: %s%n%n", cardDeck);

    Scanner scanner = new Scanner(System.in);

    while (wizard.getHero().getHp() > 0 && warrior.getHero().getHp() > 0) {
      System.out.printf("카드를 등록하시려면 1번, 공격하시려면 2번을 눌러주세요. %n%n");

      if (scanner.nextInt() == 1) {
        register(wizard, scanner, "Wizard");
        register(warrior, scanner, "Warrior");
      } else {
        attack(wizard, warrior, scanner);
        attack(warrior, wizard, scanner);
      }
    }

    System.out.println(wizard.getHero().getHp() < 1 ? "Warrior의 승리입니다." : "Wizard의 승리입니다.");
    System.out.printf("[Wizard] %s%n", wizard);
    System.out.printf("[Warrior] %s%n%n", warrior);
  }

  private static void register(final Player player, final Scanner scanner, final String name) {
    System.out.printf("[%s] 몇 번째 카드를 등록하시겠습니까?%n%n", name);

    int indexOfDeck = scanner.nextInt();
    System.out.printf("[%s] 등록할 위치를 입력해주세요. %s%n%n", name, player.getBoard());

    int indexOfBoard = scanner.nextInt();

    try {
      player.resister(indexOfDeck, indexOfBoard);
      System.out.printf("[%s] 등록되었습니다. %n%n", player.getBoard());
    } catch (IllegalStateException | IllegalArgumentException | IndexOutOfBoundsException e) {
      System.out.printf("정확한 값을 입력해주세요. %n%n");
      register(player, scanner, name);
    }
  }

  private static void attack(final Player attacker, final Player victim, final Scanner scanner) {
    System.out.printf("영웅으로 직접 공격하시려면 1번, 카드로 공격하시려면 2번을 눌러주세요. 단, 영웅으로 공격할 시 영웅의 체력이 닳습니다. %n%n");

    if (scanner.nextInt() == 1) {
      attacker.attack(victim.getHero());

      System.out.printf("%n공격하였습니다. %n%n");

      System.out.println(":: 플레이어 정보입니다. ::");
      System.out.printf("%s%n", attacker);
      System.out.printf("%s%n%n", victim);
    } else {
      attackWithCard(attacker, victim, scanner);
    }
  }

  private static void attackWithCard(final Player attacker, final Player victim, final Scanner scanner) {
    System.out.println("몇 번째 카드로 공격하시겠습니까?");
    System.out.printf("카드덱:  %s%n%n", attacker.getCardDeck());

    try {
      attacker.attack(scanner.nextInt(), victim.getHero());

      System.out.printf("%n공격하였습니다. %n%n");

      System.out.println(":: 플레이어 정보입니다. ::");
      System.out.printf("%s%n", attacker);
      System.out.printf("%s%n%n", victim);
    } catch (IllegalStateException | IllegalArgumentException e) {
      attackWithCard(attacker, victim, scanner);
    }
  }

}
