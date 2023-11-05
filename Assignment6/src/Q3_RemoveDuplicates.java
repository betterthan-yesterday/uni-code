/* Assignment 6 (100 marks in total; 5% of the final score of this course)
 *
 * Question 3 (20 marks)
 *
 * Write a Java program, user input a 1-dimension array of integers, firstly
 * sorting it in non-increasing order, and then remove the duplicates in the
 * array (if exists).
 *
 * INPUT: user input a 1-dimension array.
 * OUTPUT: sorted array in non-increasing order, and without any repeating element.
 *
 * Note: You must write sort algorithm by yourself, you are not supposed to
 * use Arrays.sort() to output the result directly.
 *
 * Hint: you can use bubble sorting algorithm or other sorting algorithms.
 *
 * Keep the input format in the example and make your code user-friendly.
 *
 * Example 1:
 * INPUT: [0, 1, 1, 0, 1, 2, 2, 3, 3, 4]
 * OUTPUT: [4, 3, 2, 1, 0]
 *
 * Example 2:
 * INPUT: [7, 0, 4, 2, 9]
 * OUTPUT: [9, 7, 4, 2, 0]
 *
 */

import java.util.Arrays;
import java.util.Scanner;

public class Q3_RemoveDuplicates {
    /* place your subroutine code here */
    static void filter(int[] arr) {

        boolean sorted = false;
        while (!sorted) {
            sorted = true;

            for (int i = 0; i < arr.length-1; i++) {
                if (arr[i] < arr[i+1]) {
                    for (int j = i+1; j < arr.length; j++) {
                        System.out.println(Arrays.toString(arr));
                        if (arr[j] <= arr[i]) {
                            int temp = arr[j-1];
                            arr[j-1] = arr[i];
                            arr[i] = temp;

                            sorted = false;
                            break;
                        } else if (j == arr.length-1) {
                            int temp = arr[j];
                            arr[j] = arr[i];
                            arr[i] = temp;

                            sorted = false;
                            break;
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        /* place your code to run your subroutine here */
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the array on one line with one space between numbers: ");
        String[] input = scanner.nextLine().split(" ");

        int[] array = new int[input.length];
        for (int i = 0; i < input.length; i++) array[i] = Integer.parseInt(input[i]);

        filter(array);
        System.out.println(Arrays.toString(array));
    }
}
