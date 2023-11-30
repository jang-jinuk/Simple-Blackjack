public class Judge {
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
}
