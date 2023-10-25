/* Assignment 4 (100 marks in total; 5% of the final score of this course)
 *
 * Question 1 (20 marks)
 *
 * Write a Java program, use 'subroutine' to finds the minimum value of
 * the first N elements of an array of type int.
 * Meanwhile, your code can throw an IllegalException (custom run-time
 * exception, which can be one provided by Java) if N is not in the range
 * of the length of input array.
 *
 * Input: user input array and number N.
 * Output: the minimum value of the first N elements of the array.
 *
 * Note: The array and N are parameters to the subroutine.
 * Users will input an array with no specific length.
 *
 */

import java.util.Scanner;

public class Q1_FindMinimum {
    /* place your subroutine code here */
    static int findMin(int[] array, int limit) {
        int min_val = array[0];

        for (int i = 1; i < limit; i++)
            min_val = Math.min(min_val, array[i]);

        return min_val;
    }

    public static void main(String[] args) {
        /* place your code to run your subroutine here */
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[1000];
        System.out.print("Enter numbers for the array; to end, enter 'end': ");

        int count = 0;
        while (true) {
            String input = scanner.next();
            if (input.equals("end")) break;
            else {
                arr[count] = Integer.parseInt(input);
                count++;
            }
        }

        System.out.print("Enter an N for the range to find the min value: ");
        int lim = scanner.nextInt();
        if (lim > count) throw new ArrayIndexOutOfBoundsException();

        System.out.println(findMin(arr, lim));
    }
}


