/* Assignment 6 (100 marks in total; 5% of the final score of this course)
 *
 * Question 4 (20 marks)
 *
 * Write a complete static method that finds the largest value in a 2-dimension array of ints.
 * The method should have one parameter, which is a 2d array of type int. The largest number
 * in the array should be returned as the value of the method.
 *
 * INPUT: user input a 2-dimension array of type int
 * OUTPUT: the largest number in input array
 *
 * Note: considering how to take users' input, you can set some rules (give users some hints)
 * to make your code user-friendly.
 * User will follow your instruction to input test example.
 *
 * Example:
 * Input: 4  6  8
 *        5  8  9
 *        2  1  8
 * Output: 9
 *
 */

import java.util.Arrays;
import java.util.Scanner;

public class Q4_GetMax {
    /* place your code here */
    static double getMax(int[][] arr) {
        double max = Double.NEGATIVE_INFINITY;
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[0].length; col++) {
                if (arr[row][col] > max) max = arr[row][col];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        /* place your code to run your subroutine here */
        Scanner scanner = new Scanner(System.in);
        int[][] array = new int[100][100];
        int row_count = 0;

        System.out.println("Enter whole row one at a time with one space between numbers; type 'end' to end: ");
        do {
            String input = scanner.nextLine();
            if (input.equals("end")) break;

            String[] str_row = input.split(" ");
            int[] int_row = new int[str_row.length];
            for (int i = 0; i < str_row.length; i++)
                int_row[i] = Integer.parseInt(str_row[i]);
            array[row_count] = int_row;

            row_count++;
        } while (true);

        int[][] proper_array = new int[row_count][array[0].length];
        for (int i = 0; i < proper_array.length; i++)
            proper_array[i] = Arrays.copyOf(array[i], array[i].length);

        System.out.println(getMax(proper_array));
    }
}
