/* Assignment 4 (100 marks in total; 5% of the final score of this course)
 *
 * Question 5 (20 marks)
 *
 * Write a java program to convert Roman numbers to integer.
 * Roman numerals are represented by seven different symbols:
 * I, V, X, L, C, D and M
 *
 * Symbol   Value
 *   I        1
 *   V        5
 *   X        10
 *   L        50
 *   C        100
 *   D        500
 *   M        1000
 *
 * For example, 2 is written as II in Roman numeral, just two one's added together.
 * 12 is written as XII, which is simply X + II.
 * The number 27 is written as XXVII, which is XX + V + II.
 *
 * Roman numerals are usually written largest to smallest from left to right.
 * However, the numeral for four is not IIII. Instead, the number four is written
 * as IV. Because the one is before the five we subtract it making four.
 * The same principle applies to the number nine, which is written as IX.
 * There are six instances where subtraction is used:
 *  I can be placed before V (5) and X (10) to make 4 and 9.
 *  X can be placed before L (50) and C (100) to make 40 and 90.
 *  C can be placed before D (500) and M (1000) to make 400 and 900.
 *
 * Input: Roman number (user input, string type)
 * Output: print out corresponding integer
 *
 * Example: if the user enters 'LVIII', the program should output 'LVIII -> 58'
 *
 */

import java.util.Scanner;

public class Q5_Roman2Integer {
    /* place your subroutine code here */
     static int indexOf(char[] arr, char element) {
         for (int index = 0; index < arr.length; index++) {
             if (arr[index] == element)
                 return index;
         }
         return -1;
     }

    static int Roman2Decimal(String numeral) {

        int deci = 0;
        char[] numeral_array = numeral.toCharArray();
        char[] letters = {'M', 'D', 'C', 'L', 'X', 'V', 'I'};
        int[] key = {1000, 500, 100, 50, 10, 5, 1};

        for (int i = 0; i < numeral_array.length; i++) {
            if (i != numeral_array.length-1) {
                if (indexOf(letters, numeral_array[i]) > indexOf(letters, numeral_array[i + 1])) continue;
            }

            if (i != 0) {
                if (indexOf(letters, numeral_array[i]) < indexOf(letters, numeral_array[i - 1])) {
                    deci += key[indexOf(letters, numeral_array[i])] - key[indexOf(letters, numeral_array[i - 1])];
                    continue;
                }
            }

            deci += key[indexOf(letters, numeral_array[i])];
        }

        return deci;
    }

    public static void main(String[] args){
        /* place your code to run your subroutine here */
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a Roman numeral: ");
        String numeral = scanner.next();

        System.out.println(Roman2Decimal(numeral));
    }
}
