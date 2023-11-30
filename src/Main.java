//1. 게임 타이틀 출력
//2. Game 현재턴 기능 구현
//3. 1 - 11까지 숫자 중 숫자를 랜덤으로 두개 고르는 기능 구현
//4. 고른 숫자카드를 각각 하나씩 플레이어와 딜러에 전달하고 전달하고 출력하는 기능 구현
//5. 계속 게임을 계속 진행할지 진행여부를 결정하는 기능 구현
public class Main {
    public static void main(String[] args) {
        System.out.println("간단한 카드 게임을 시작합니다\n");
        Card star = new Card();
        star.Game();
    }
}
