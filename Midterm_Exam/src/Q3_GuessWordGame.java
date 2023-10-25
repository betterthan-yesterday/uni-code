/* Midterm Exam (100 marks in total; 20% of the final grade of this course)
 *
 * Question 3 (40 marks)
 * Write a program that first takes an input word no longer than 3 characters from the host of the game.
 * Then, the program asks a player to guess what the word is.
 *
 * Only use the 26 characters in lower cases from the alphabet, that are: a, b, c, d, ..., x, y, z.
 *
 * The following is an example to show how the program should work step by step.
 *
 * 1. The program asks the host of the game to input a word no longer than 3 characters.
 * For example, let's assume the host inputs the word: "cat"
 *
 * 2. The program asks the player to iteratively guess what the word is, in a character-by-character manner.
 *
 * 3. If the player guesses a "h" for the first character. The program should display
 * "h has a greater alphabetic order than the first character." and then, it should ask the user to guess again by displaying
 * "please guess again."
 *
 * 4. If the player guesses a character "b" for the first character. The program should display
 * "b has a smaller alphabetic order than the first character." and then, it should ask the user to guess again by displaying
 * "please guess again."
 *
 * 5. if the player guesses a "c" for the first character. The program should display
 * "c is correct for the first character." and then, it should ask the user to guess the next character by displaying
 * "please guess the next character."
 *
 * 6. The program stops when any of the following two conditions is satisfied:
 *     Condition 1: the user failed more than 5 times when guessing one character. In this case, the program displays "Game failed." and stops
 *     Condition 2: the user successfully guesses the word. In this case, the program displays "Congratulations! Correct word is: cat" and stops.
 *
 * IMPORTANT NOTE 1: it is fine to either printing out the quote "" or not printing out the quote "". Grading will not be based on the display format of quote sign.
 */

import java.util.Scanner;

public class Q3_GuessWordGame {
    /* place your subroutine code here if there is any */

    public static void main(String args[])
    {
        /* Place your main code here */
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter word to guess: ");
        String host_word = scanner.next();
        int count = 0;
        int trials = 0;

        do {
            System.out.print("Enter guessing character:");
            char guessing_char = scanner.next().charAt(0);
            trials++;

            if (guessing_char < host_word.charAt(count)) {
                System.out.printf("%c has a smaller alphabetic order than the first character.\n", guessing_char);
                if (trials == 5) {
                    System.out.println("Game failed.");
                    break;
                }
                System.out.println("please guess again.");
            } else if (guessing_char > host_word.charAt(count)) {
                System.out.printf("%c has a greater alphabetic order than the first character.\n", guessing_char);
                if (trials == 5) {
                    System.out.println("Game failed.");
                    break;
                }
                System.out.println("please guess again.");
            } else {
                System.out.printf("%c is correct for the first character.\n", guessing_char);
                count++;
                if (count == host_word.length()) {
                    System.out.printf("Congratulations! Correct word is: %s", host_word);
                    break;
                }

                System.out.println("please guess the next character.");
                trials = 0;
            }
        } while (true);
    }
}