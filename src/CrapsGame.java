import java.util.Random;
import java.util.Scanner;

public class CrapsGame {
    private static final Random rnd = new Random();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean playAgain = true;
        while (playAgain) {
            System.out.println("Let's play a round of craps!");
            int result = playCraps();

            if (result == 0) {
                System.out.println("Sorry, you lose by crapping out!");
            } else if (result == 1) {
                System.out.println("Congratulations!You win with a natural!");
            } else {
                boolean won = playPoint(result);
                if (won) {
                    System.out.println("Congratulations! You made the point! You won!");
                } else {
                    System.out.println("Sorry, you lose by rolling a 7!");
                }
            }

            System.out.print("Do you want to play again? (y/n): ");
            String response = scanner.nextLine().toLowerCase();
            playAgain = response.equals("y");
        }

        System.out.println("Thanks for playing Craps! Goodbye!");

    }

        private static int playCraps() {
            int sum = rollDice();
            System.out.println("You rolled " + sum + ".");

            if (sum == 2 || sum == 3 || sum == 12) {
                System.out.println("You crapped out!");
                return 0;
            } else if (sum == 7 || sum == 11) {
                System.out.println("You won with a natural!");
                return 1;
            } else {
                System.out.println("The point is now " + sum + ".");
                return sum;
            }
        }

        private static boolean playPoint(int point) {
            while (true) {
                int sum = rollDice();
                System.out.println("You rolled " + sum + ".");

                if (sum == point) {
                    return true;
                } else if (sum == 7) {
                    return false;
                } else {
                    System.out.println("Trying for the point...");
                }
            }
        }

        private static int rollDice() {
        int die1 = rnd.nextInt(6) + 1;
        int die2 = rnd.nextInt(6) + 1;
        return die1 + die2;
    }
}