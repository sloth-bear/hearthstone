## 객체지향 설계 방법
1. 도메인에 필요한 객체 정리 
2. 필요한 메시지 추가 
3. 메시지를 수신할 객체 선택 
4. 더 이상 필요한 메시지가 없을 때까지 2~3 과정 반복 
5. 객체들이 수신하는 메시지를 바탕으로 객체들의 인터페이스 구성 
6. 객체들의 메소드 구현 



## 하스스톤 게임 Spec
### Spec
1. 플레이어 2명이 생명력 30의 영웅을 가지고 시작한다.
2. 초기 카드덱의 카드 개수는 30개로 시작된다.  
3. 첫 턴에서 각 플레이어는 카드덱에서 선공 시 3장, 후공 시 4장의 카드를 받는다.
4. 첫 턴 이후 각 플레이어는 카드를 1장씩 받는다. 
5. 플레이어가 받은 카드 중 하나를 게임보드에 등록하면 카드는 보드에 놓여진다.
6. 플레이어가 받은 카드 중 하나로 영웅을 공격하면 영웅은 피해를 입는다.
7. 영웅의 생명력이 0이 되면 영웅은 파괴되고 게임은 끝난다.

### 참고
- 기존 하스스톤 게임 규칙에서 스펙 다운
  <details> 
    <summary>기존 하스스톤 게임 규칙 확인하기</summary>

       1. 플레이어 2명의 영웅이 각 30의 생명력을 가지고 시작한다.
       2. 상대 영웅의 생명력이 0 이하로 감소되면 승리한다.
       3. 각 플레이어는 카드덱을 가진다.
       4. 덱의 카드 개수는 30장으로 고정된다. 
       5. 덱에 같은 카드는 2장까지 넣을 수 있다. 
       6. 일반 카드와 황금 카드는 같은 카드로 취급되므로 일반 2장, 황금 2장을 넣을 수 없다. 
       7. 게임 시작 후 선후공은 무작위로 결정된다. 
       8. 게임 시작 후 선공은 카드 3장, 후공은 카드 4장을 받는다. 
       9. 후공은 추가적으로 '동전 한 닢' 카드를 받는다. 
          1. 동전 한 닢 카드는 해당 턴에서만 일시적으로 마나를 1 상승시킨다. 
       10. 패에 있는 카드가 10장이면 이후로 뽑는 카드는 파괴된다.
       11. 각 플레이어는 마나를 가진다. 
       12. 각 플레이어는 턴이 끝나면 마나가 1 늘어난다. 
       13. 마나의 최대 수는 10이다. 
       14. 덱에 있는 카드를 사용할 때 마나가 소모된다. 
       15. 덱에 있는 카드를 사용할 때 카드별로 소모되는 마나는 차이가 있다. 
       16. 덱에 있는 카드는 카드의 성격에 따라 직접 영웅을 공격할 수도, 게임보드에 등록할 수도 있다.
  </details> 
- 카드의 도발, 영웅의 개별적 능력 등은 추후 추가해볼 예정



## 하스스톤에 필요한 객체 정리 
1. `CardDeck`
2. `Card`
3. `Player`
4. `Board`
5. `Hero`



## 필요한 메시지
1. 카드를 나눠줘라
2. 카드를 받아라
3. 카드를 등록해라 
4. 카드를 꺼내라 
5. 공격해라
6. 피해를 입어라
7. 파괴되어라
