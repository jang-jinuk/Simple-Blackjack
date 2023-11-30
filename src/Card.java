public class Card {
    void Game() {
        int playerCard;
        int dealerCard;
        int[] randBox = new int[2];

        randBox = randomCard();
        playerCard = randBox[0];
        dealerCard = randBox[1];

        System.out.printf("You :  [%2d]\n",playerCard);
        System.out.printf("Dealer :  [%2d]\n",dealerCard);

    }
    int [] randomCard() {
        int [] randomBox = new int[2];

        for (int i = 0; i < 2; i++) {
            randomBox[i] = (int) (Math.random() * 11 + 1);
        }

        return randomBox;
    }
}
