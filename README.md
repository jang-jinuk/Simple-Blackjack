# 1단계: 간단 카드 게임 구현하기
<details>
<summary>문제 설명 및 요구사항</summary>

## 문제 설명
1-11까지 범위의 숫자카드 중 랜덤으로 2개를 뽑아 플레이어와 딜러가 각각 하나씩 나누어 갖고   
서로의 숫자카드를 비교해서 딜러보다 더 큰 숫자카드를 가지고 있으면 플레이어가 승리하는 프로그램을 구현하시오

## 요구사항
1. 승패에 대한 메세지를 출력할 것
2. 프롬포트로 게임중단 여부를 물어볼 것
3. 게임중단 여부는 y,n으로 판단하며 대,소문자 관계없이 입력 받을 것
4. y, n 외에 다른 것을 입력했을 때 다시 입력 받을 것
5. 게임 종료 시 종료 메세지를 출력할 것

</details>

# 구조
Card 객체를 실행해주는 Main class와 카드를 뽑아 나열하고 게임을 진행해주는 Card class, 게임의 승패여부를 판단해주는 Judge class를 구현하였다.

### 목차
[1. Main class](#Main-class)   
[2. Card class](#Card-class)   
[3. Judge class](#Judge-class)   

# Main class
Card 객체와 Game()메서드를 활용하여 Main클래스는 단순하게 구현하였다.

```java
  System.out.println("간단한 카드 게임을 시작합니다\n");
  Card star = new Card();
  star.Game();
```
# Card class
|메서드|기능|
|---|---|
|Game|게임을 진행|
|randomCard|1-11까지 범위에 숫자를 랜덤으로 2개 뽑는 기능 수행|
|printCard(playCard,dealerCard)|랜덤으로 뽑은 숫자를 나열해 출력|
|goStop()|게임 중단 여부 기능 수행|

### Game 메서드
- 게임을 진행

1. randomCard, PrintCard, goStop 메서드를 통해 게임을 진행한다.
2. 사용자 입력에 따라 게임을 종료한다.

```java
  void Game() {
      ArrayList<Integer> playerCard = new ArrayList<>();
      ArrayList<Integer> dealerCard = new ArrayList<>();
      int[] randBox = new int[2];
      int turn = 1;
      int victory = 0, defeact = 0, draw = 0;
      int[] outComeBox = new int[3];

      while(true) {
          System.out.printf("Game %d\n",turn);
          turn++;

          randBox = randomCard();
          playerCard.add(randBox[0]);
          dealerCard.add(randBox[1]);

          printCard(playerCard, dealerCard);
          Judge get = new Judge();
          outComeBox = get.outCome(randBox,victory,defeact,draw);

          victory = outComeBox[0];
          defeact = outComeBox[1];
          draw = outComeBox[2];

         char playerSelection = goStop();

          if (playerSelection == 'n') {
              System.out.println("게임을 종료합니다.\n" + "플레이해주셔서 감사합니다.");
              break;
          }
          System.out.println();
      }
  }
```
### randomCard 메서드
- 1-11까지 범위에 숫자를 랜덤으로 2개 뽑는 기능 수행

1. random 메서드를 통해 1-11까지 범위에 숫자를 2개 뽑는다.
2. randomBox 배열에 두 숫자를 저장하여 반환한다.

```java
  int [] randomCard() {
          int [] randomBox = new int[2];
  
          for (int i = 0; i < 2; i++) {
              randomBox[i] = (int) (Math.random() * 11 + 1);
          }
          return  randomBox;
  }
```
### printCard 메서드
- 랜덤으로 뽑은 숫자를 나열해 출력

1. 랜덤으로 뽑은 숫자가 저장된 playerCard, dealerCard 리스트를 매개변수로 받는다.
2. 리스트를 각각 출력한다.

```java
  void printCard(ArrayList<Integer> playerCard,ArrayList<Integer> dealerCard) {
      System.out.print("You   : ");
      for (int i = 0; i < playerCard.size(); i++) {
          System.out.printf("[%2d] ",playerCard.get(i));
      }
      System.out.println();

      System.out.print("Dealer: ");
      for (int i = 0; i < dealerCard.size(); i++) {
          System.out.printf("[%2d] ",dealerCard.get(i));
      }
      System.out.println();
  }
```
### goStop 메서드
- 게임 중단 여부 기능 수행

1. 사용자에게 'y' 또는 'n'을 입력 받는다.
2. 입력 받은 값을 playerSelection 변수에 저장하여 반환한다.

```java
 char goStop(){
        char playerSelection;

        do {
            System.out.print("한 게임 더 하시겠습니까? (Y / N) ");
            Scanner sc = new Scanner(System.in);
            String playerInput = sc.next();
            playerInput = playerInput.toLowerCase();
            playerSelection = playerInput.charAt(0);
        }while (playerSelection != 'y' && playerSelection != 'n');

        return playerSelection;
    }
```
# Jude class
|메서드|기능|
|---|---|
|outCome(randomBox,victory,defeact,draw)|게임 승패를 판단하고 결과를 반환|

### outCome 메서드
- 게임 승패 판단하고 결과를 반환

1. palyerCard와 dealerCard를 비교하여 승패를 판단한다.
2. 승패에 따른 메세지를 출력
3. 현재 전적 메세지를 출력

```java
int [] outCome(int [] randomBox, int victory, int defeact, int draw) {
        int playerCard = randomBox[0];
        int dealerCard = randomBox[1];
        int[] outComeBox = new int[3];

        if (playerCard > dealerCard) {
            ++victory;
            System.out.println("당신이 이겼습니다.");
        }
        else if(playerCard < dealerCard) {
            ++defeact;
            System.out.println("딜러가 이겼습니다.");
        }
        else {
            ++draw;
            System.out.println("비겼습니다.");
        }

        System.out.printf("현재 전적 : %d승 ",victory);
        if (draw > 0) {
            System.out.printf("%d무 ",draw);
        }
        System.out.printf("%d패\n",defeact);

        outComeBox[0] = victory;
        outComeBox[1] = defeact;
        outComeBox[2] = draw;
        return outComeBox;
    }
```
