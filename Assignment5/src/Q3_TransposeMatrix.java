/* Assignment 5 (100 marks in total; 5% of the final score of this course)
 *
 * Question 3 (30 marks)
 *
 * Write a java program to compute the transpose of a user input matrix,
 * whose elements are all integers.
 *
 * Converting rows of a matrix into columns and columns of a matrix into
 * row is called transpose of a matrix.
 *
 * INPUT: user input matrix (2D array).
 * OUTPUT: the transpose of input matrix.
 *
 * Note: considering how to take users' input, you can set some rules
 * (give users some hints) to make your code user-friendly.
 * User will follow your instruction to input test example.
 *
 * Example:
 * INPUT: 4  6  8
 *        5  8  9
 *        2  1  8
 *
 * OUTPUT: 4  5  2
 *         6  8  1
 *         8  9  8
 *
 */

import java.util.Arrays;
import java.util.Scanner;

public class Q3_TransposeMatrix {
    /* place your subroutine code here */
    static String[] transpose(String[] arr) {
        String[] transpose = new String[arr.length];

        for (int i = 0; i < arr.length; i++) {
            
        }

        return transpose;
    }

    public static void main(String[] args) {
        /* place your code to run your subroutine here */
        Scanner scanner = new Scanner(System.in);
        String[] arr = new String[1000];
        int counter = 0;

        System.out.println("Enter rows of matrix on different lines, with one space in between numbers, type 'end' to end: ");
        do {
            String input = scanner.nextLine();
            if (input.equals("end")) break;
            arr[counter] = input;
            counter++;
        } while (true);

        String[] arr_copy = new String[counter];
        System.arraycopy(arr, 0, arr_copy, 0, counter);

        String[] tran_mat = transpose(arr_copy);
        for (int i = 0; i < tran_mat.length; i++)
            System.out.println(tran_mat[i]);
    }
}
