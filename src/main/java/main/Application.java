package main;

import domain.Board;
import domain.Player;
import domain.card.*;
import domain.hero.Warrior;
import domain.hero.Wizard;
import java.util.List;

public class Application {

  public static void main(String[] args) {
    System.out.println(":: 게임이 시작됩니다. ::");

    // 1. 카드덱 생성
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
    System.out.printf("wizard Player의 카드덱: %s%n", wizard.getCardDeck());
    System.out.printf("warrior Player의 카드덱: %s%n", warrior.getCardDeck());
    System.out.printf("남은 카드덱: %s%n%n", cardDeck);

    System.out.println("카드를 등록하시려면 1번, 공격하시려면 2번을 눌러주세요.");
//    wizard.resister(0, 0);
//    warrior.resister(1, 1);
//
//    // 4. 영웅을 직접 공격하기
//    wizard.attack(warrior.getHero());
//    warrior.attack(wizard.getHero());
//
//    // 5. 카드로 영웅을 공격하기
//    wizard.attack(3, warrior.getHero());
//    warrior.attack(4, wizard.getHero());
  }

}
