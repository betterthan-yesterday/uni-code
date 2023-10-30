/* Assignment 5 (100 marks in total; 5% of the final score of this course)
 *
 * Question 2 (30 marks)
 *
 * Write a subroutine, user input an 1D array of integers and an integer target,
 * return indices of the two numbers such that they add up to target.
 *
 * INPUT: user input array and target
 * OUTPUT: the indices of the two numbers such that they add up to target.
 *
 * The array and target are parameters to the subroutine.
 * User can get hint to input array and target number, respectively.
 *
 * Keep the input format in the example and make your code user-friendly.
 *
 * Example:
 * INPUT: [2,7,11,15], 9
 * OUTPUT: [0,1]
 *
 */

import java.util.Arrays;
import java.util.Scanner;

public class Q2_TwoSum {
    /* place your subroutine code here */
    static int[] findSum(int[] arr, int target) {
        int[] addends = new int[2];
        for (int i = 0; i < arr.length; i++) {
            int diff = target - arr[i];
            for (int j = i; j < arr.length; j++) {
                if (arr[j] == diff) {
                    addends[0] = i;
                    addends[1] = j;
                    return addends;
                }
            }
        }
        return addends;
    }

    public static void main(String[] args) {
        /* place your code to run your subroutine here */
        Scanner scanner = new Scanner(System.in);
        int[] arr1 = new int[1000];
        int target;
        int counter = 0;

        System.out.print("Enter list of numbers one-by-one; type 'end' to end: ");
        do {
            String input = scanner.next();
            if (input.equals("end")) break;
            arr1[counter] = Integer.parseInt(input);
            counter++;
        } while (true);

        int[] arr2 = new int[counter];
        System.arraycopy(arr1, 0, arr2, 0, counter);

        System.out.print("Enter target number: ");
        target = scanner.nextInt();

        System.out.println(Arrays.toString(findSum(arr2, target)));
    }
}
