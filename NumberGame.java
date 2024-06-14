import java.util.*;
public class NumberGame {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        Random random=new Random();

        int maxAttempts=10;
        int rounds=0;
        int totalScore=0;
        boolean playAgain=true;

        while (playAgain) {
            rounds++;
            int numberToGuess=random.nextInt(100) + 1;
            int attempts=0;
            boolean hasGuessedCorrectly=false;

            System.out.println("Round " + rounds + ": Guess a number between 1 and 100.");

            while (attempts < maxAttempts && !hasGuessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = sc.nextInt();
                attempts++;
                if (userGuess < numberToGuess) {
                    System.out.println("Low!");
                }
                else if (userGuess > numberToGuess) {
                    System.out.println("High!");
                }
                else {
                    hasGuessedCorrectly = true;
                    System.out.println("Correct! You've guessed the number in " + attempts + " attempts");
                }
            }
            if (!hasGuessedCorrectly) {
                System.out.println("Sorry, you've used all " + maxAttempts + " attempts. The number was " + numberToGuess);
            }
            
            totalScore+=hasGuessedCorrectly?(maxAttempts-attempts+1):0;
            System.out.print("Do you want to play another round? (yes/no): ");
            playAgain = sc.next().equalsIgnoreCase("yes");
        }
        System.out.println("Game Over! You've played " + rounds + " rounds with a total score of " + totalScore + ".");
        sc.close();
    }
}