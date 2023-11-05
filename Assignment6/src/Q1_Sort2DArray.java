/* Assignment 6 (100 marks in total; 5% of the final score of this course)
 *
 * Question 1 (20 marks)
 *
 * Write a java program, use "subroutine" to finish sorting a 2-dimension array.
 *
 * User input a 2-dimension array of double type, return it in non-decreasing
 * order according to values in the first raw, if there are two or more same
 * element in the first raw, keep the original sequence.
 *
 * INPUT: a user input 2-dimension array.
 * OUTPUT: sorted input array in non-decreasing order according to values in the first row.
 *
 * Note: considering how to take users' input, you can set some rules (give users some hints)
 * to make your code user-friendly.
 * User will follow your instruction to input test example.
 *
 * Example 1
 * INPUT: if user input array (Order 2*4) is
 *        1.45  0.25  8.95  0.99
 *        2.56  5.67  0.47  2.65
 *
 * OUTPUT: 0.25  0.99  1.45  8.95
 *         5.67  2.65  2.56  0.47
 *
 * Example 2
 * INPUT: if user input array (Order 5*5) is
 *        0.95  0.23  0.95  0.95  0.65
 *        2.56  5.67  0.47  2.65  0.47
 *        1.45  0.25  8.95  0.99  0.67
 *        5.67  2.65  0.25  8.95  0.99
 *        1.23  4.21  0.97  7.64  8.52
 *
 * OUTPUT: 0.23  0.65  0.95  0.95  0.95
 *         5.67  0.47  2.56  0.47  2.65
 *         0.25  0.67  1.45  8.95  0.99
 *         2.65  0.99  5.67  0.25  8.95
 *         4.21  8.52  1.23  0.97  7.64
 *
 */

import java.util.Arrays;
import java.util.Scanner;

public class Q1_Sort2DArray {
    /* place your subroutine code here */
    static void sort2DArray(double[][] arr_to_sort) {
        int longest_sort = 1;
        while (longest_sort != arr_to_sort[0].length) {
            longest_sort = 1;

            for (int col = 0; col < arr_to_sort[0].length-1; col++) {
                if (arr_to_sort[0][col] > arr_to_sort[0][col+1]) {
                    for (int row = 0; row < arr_to_sort.length; row++) {
                        double temp_elem = arr_to_sort[row][col+1];
                        arr_to_sort[row][col+1] = arr_to_sort[row][col];
                        arr_to_sort[row][col] = temp_elem;
                    }
                } else longest_sort++;
            }
        }
    }

    public static void main(String[] args) {
        /* place your code to run your subroutine here */
        Scanner scanner = new Scanner(System.in);
        double[][] array = new double[100][100];
        int row_count = 0;

        System.out.println("Enter whole row one at a time with one space between numbers; type 'end' to end: ");
        do {
            String input = scanner.nextLine();
            if (input.equals("end")) break;

            String[] str_row = input.split(" ");
            double[] doub_row = new double[str_row.length];
            for (int i = 0; i < str_row.length; i++)
                doub_row[i] = Double.parseDouble(str_row[i]);
            array[row_count] = doub_row;

            row_count++;
        } while (true);

        double[][] proper_array = new double[row_count][array[0].length];
        for (int i = 0; i < proper_array.length; i++)
            proper_array[i] = Arrays.copyOf(array[i], array[i].length);

        sort2DArray(proper_array);
        for (double[] doubles : proper_array) System.out.println(Arrays.toString(doubles));
    }
}
