import java.util.*;
public class Numbergame {
    public static void main(String[] args) {
        int random_num, input, count, totalScore = 0, attempts;
        boolean playAgain = true;
        Random r = new Random();
        Scanner sc = new Scanner(System.in);

        System.out.println("\n\t\t\t\t***** GUESS THE NUMBER  *****");

        while (playAgain) {
            System.out.println("\n\n  You have to pick a number from 1 TO 100.");
            System.out.println("\t\t\t\tLet's start the game.\n\t\t\t Can you guess what the number is?");
            System.out.print("\n Enter the number of attempts you want for this game:");
            while (true) {
                try {
                    attempts = sc.nextInt();
                    if (attempts <= 0) {
                        System.out.println("Enter a positive integer for attempts:");
                        continue;
                    }
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Enter only an integer number.");
                    sc.nextLine(); // Clear the invalid input
                }
            }

            random_num = r.nextInt(100) + 1; // To enter number between 1 and 100
            count = 0;
            boolean guess = false;

            while (count < attempts) {
                System.out.print("\nYour attempt number " + (count + 1) + ": \nEnter your guess: ");
                try {
                    input = sc.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Enter only an integer number.");
                    sc.nextLine(); // Clear the invalid input
                    continue;
                }
                count++;
                if (input == random_num) {
                    guess = true;
                    System.out.println("\n\tCongratulations! You guessed the number correctly in " + count + " attempts.");
                    break;
                } else if (input > random_num) {
                    System.out.println("It's too high! Try a lower number.");
                } else {
                    System.out.println("It's too low! Try a higher number.");
                }
            }

            int roundScore = guess ? attempts + 1 - count : 0;
            totalScore += roundScore;
            if (!guess) {
                System.out.println("\n\t\t\tSorry! You have run out of attempts.\n\t\t\t\t\tThe number was: " + random_num + ".");
            }
            System.out.println("\t\t\tYour score: " + roundScore);
            System.out.println("\t\t\tYour total score for this match: " + totalScore);

            System.out.print("\n\tDo you want to continue the game? (y/n):\n\t(Press 'y' to continue and 'n' to exit): ");
            String response = sc.next().toLowerCase();
            playAgain = response.equals("y");
        }

        System.out.println("\n\t\t\t\tYour final total score: " + totalScore + " Keep trying ");
        System.out.println("\n\t\t\t\t.....Thank you for playing.....\n\t\t\t\t\t Visit again !!");
    }
}
