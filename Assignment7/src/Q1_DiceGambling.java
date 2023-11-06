/* Assignment 7 (100 marks in total; 5% of the final score of this course)
 *
 * Question 1 (40 marks)
    Use java to implement a class Dice, a class Gambler and a method that continue gambling between two gamblers until one
    gambler cannot afford the stake.

 */

import java.util.Random;

// the class of Dice to play
class Dice {
    private int num_faces;

    Dice(){
        num_faces=6; // standard dice with 6 faces by default.
    }

    // implement the roll dice method that roll the dice once and return the value of the roll.
    // (5 marks)
    public int rollDice() {
        /* place your code here */
        Random rand = new Random();
        return rand.nextInt(num_faces+1) + 1;
    }
}

// the class of gambler
class Gambler {
    public int money;
    public Dice die;

    Gambler(int initial_money) {
        money = initial_money;
        die = new Dice();
    }

    // use static method to implement the gambling activity.
    // In a gambling activity, two gamblers gamble on a stake.
    // Each gambler rolls a die, the gambler who roles a larger value wins the stake.
    // if it is a due, then roll again, until there is a winner.
    // Note: a gambler cannot start gamble if he does not have more money than the amount of stake.
    // Note: return false if at least one gambler cannot afford the stake. Otherwise, return true.
    // Note: print the result of rolled dice values, and the winner of the gambling.
    // (20 marks)
    static boolean gambling(Gambler gambler_1, Gambler gambler_2, int stake) {
        /* place your code here */
        if (gambler_1.money < stake | gambler_2.money < stake) return false;

        int roll_1;
        int roll_2;
        do {
            roll_1 = gambler_1.die.rollDice();
            roll_2 = gambler_2.die.rollDice();

            if (roll_2 > roll_1) {
                gambler_2.money += stake;
                gambler_1.money -= stake;
                System.out.printf("Gambler 1 roll: %d, Gambler 2 roll: %d: Gambler 2 wins\n", roll_1, roll_2);
            } else if (roll_1 > roll_2) {
                gambler_1.money += stake;
                gambler_2.money -= stake;
                System.out.printf("Gambler 1 roll: %d, Gambler 2 roll: %d: Gambler 1 wins\n", roll_1, roll_2);
            } else {
                System.out.printf("Gambler 1 roll: %d, Gambler 2 roll: %d: Re-roll\n", roll_1, roll_2);
            }
        } while (roll_2 == roll_1) ;

        return true;
    }
}

public class Q1_DiceGambling {

    // Continue Gambling until one gambler cannot afford the stake
    // Print the amount of money of each gambler after each round of gambling.
    // Print the value of rolled dice for each gambler in each round of gambling.
    // (15 marks)
    public static void keepGambling(Gambler gambler_1, Gambler gambler_2, int stake, int max_gambling_times) {
        /* place your code here */
        int count = 0;
        while (Gambler.gambling(gambler_1, gambler_2, stake) & count != max_gambling_times) {
            System.out.printf("Gambler 1 money: %d, Gambler 2 money: %d\n", gambler_1.money, gambler_2.money);
            count++;
        }
    }

    public static void main(String[] args) {
        int initial_money = 20;
        int stake = 5;
        int max_gambling_times = 20;

        Gambler gambler1 = new Gambler(initial_money);
        Gambler gambler2 = new Gambler(initial_money);

        keepGambling(gambler1, gambler2, stake, max_gambling_times);

    }
}
