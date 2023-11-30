import java.util.ArrayList;
import java.util.Scanner;

public class Card {
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
    int [] randomCard() {
        int [] randomBox = new int[2];

        for (int i = 0; i < 2; i++) {
            randomBox[i] = (int) (Math.random() * 11 + 1);
        }
        return  randomBox;
    }
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
}
