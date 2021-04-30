## 소개
* 간소화된 하스스톤 게임 구현 
* OOP 설계 공부를 위한 연습 단계 
* 버그 혹은 개선사항이 있다면 알려주세요!


## 빌드
```
./gradlew clean build
```


## 실행
```
./gradlew run
```


## 구현
### 객체지향 설계 방법
1. 도메인에 필요한 객체 정리 
2. 필요한 메시지 추가 
3. 메시지를 수신할 객체 선택 
4. 더 이상 필요한 메시지가 없을 때까지 2~3 과정 반복 
5. 객체들이 수신하는 메시지를 바탕으로 객체들의 인터페이스 구성 
6. 객체들의 메소드 구현 


### 하스스톤 게임 Spec
#### Spec
1. `플레이어` 2명이 생명력 15의 `영웅`을 가지고 시작한다.
2. 초기 `카드덱`의 `카드` 개수는 10개로 시작한다. 
3. 첫 턴에서 각 `플레이어`는 `카드덱`에서 선공 시 3장, 후공 시 4장의 `카드`를 받는다.
4. 각 `플레이어`는 자신의 턴에 `카드`를 1장씩 받는다. 
5. `플레이어`가 받은 `카드` 중 하나를 `게임보드`에 등록하면 `카드`는 `보드`에 놓여진다.
6. `플레이어`가 받은 `카드` 중 하나로 `영웅`을 공격하면 `영웅`은 피해를 입는다.
7. `플레이어`의 `영웅`으로 상대 `영웅`을 공격하면 `영웅`은 피해를 입고, 공격한 `플레이어`의 `영웅`도 상대의 공격력 만큼 피해를 입는다. 
8. `영웅`의 생명력이 0이 되면 `영웅`은 파괴되고 게임은 끝난다.

#### 참고
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
- 추후 추가하고 싶은 기능
  - 플레이어별 카드덱 가지기
  - 게임보드에 등록된 카드로 공격
  - 게임보드에 등록된 카드에 대한 공격
  - 피해 받은 카드는 게임보드에서 소멸  
  - ...etc


### 하스스톤에 필요한 객체 정리 
1. `CardDeck`
2. `Card`
3. `Player`
4. `Board`
5. `Hero`


### 필요한 메시지
- 카드 나눔 시
  - 카드를 나눠줘라
  - 카드를 받아라
- 카드 등록 시 
  - 카드를 등록해라
  - 카드를 꺼내라
- 공격 시
  - 공격해라
  - 카드를 꺼내라 
  - 피해를 입어라


### 필요한 메시지를 수신할 객체 선택
#### 카드 나눔 시
<img width="469" alt="image" src="https://user-images.githubusercontent.com/62458327/116486821-77fe9d00-a8c9-11eb-9ba8-842d3be2bd11.png">

#### 카드 등록 시 
<img width="439" alt="image" src="https://user-images.githubusercontent.com/62458327/116184398-a316ae80-a75a-11eb-8970-fd77f4144412.png">

#### 공격 시 
##### 카드의 공격
<img width="459" alt="image" src="https://user-images.githubusercontent.com/62458327/116194621-0bba5700-a76c-11eb-9615-9819147e107a.png">

##### 영웅의 공격
<img width="670" alt="image" src="https://user-images.githubusercontent.com/62458327/116194641-1248ce80-a76c-11eb-9009-7c72f48975a3.png">


### 참조
* 객체지향의 사실과 오해
* https://okky.kr/article/358197
* https://github.com/jojoldu/oop-java
* https://jupiny.com/2019/01/12/object-orientation-fact-and-misunderstanding/ 
