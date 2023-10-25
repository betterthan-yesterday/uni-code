/* Assignment 3 (100 marks in total; 5% of the final score of this course)
 *
 * Question 3 (30 marks)

Many companies use telephone numbers like 555-GET-Food so the number is easier for their customers to remember.
On a standard telephone, the alphabetic letters are mapped to numbers in the following fashion:

A, B, and C = 2
D, E, and F = 3
G, H, and I = 4
J, K, and L = 5
M, N, and O = 6
P, Q, R, and S = 7
T, U, and V = 8
W, X, y, and Z = 9
Write an application that asks the user to enter a 10-character telephone number in the format XXX-XXX-XXXX.
The application should display the telephone number with any alphabetic characters that appeared in the original
translated to their numeric equivalent.

Example: if the user enters 555GETFOOD the application should display 555-438-3663.
*

 */

import java.util.Scanner;

public class Q3_AlphabeticPhoneNumber
{
    private static Scanner input;

    public static void main(String[] args) {
        input = new Scanner(System.in);
        System.out.println("Enter The Phone Number (With Letters): ");
        String initial_phone_number = input.nextLine();

        initial_phone_number = initial_phone_number.toUpperCase();
        long phone_number_final = full_number(initial_phone_number);

        System.out.printf("%nOutput phone number for '%s' is '%s'",
                initial_phone_number, phone_number_final);
    }

    public static long full_number(String initial_phone_number)
    {
        // Use long instead of int for 'number' if the string will be longer than max int value
        // 2147483647, which is '10 digits'
        long number = 0; // 'number' is the digital phone number to compute from the initial alphabetic phone number.



        /* place your code here */
        String new_number = "";
        for (char num : initial_phone_number.toCharArray()) {
            switch (num) {
                case 'A', 'B', 'C' -> new_number += "2";
                case 'D', 'E', 'F' -> new_number += "3";
                case 'G', 'H', 'I' -> new_number += "4";
                case 'J', 'K', 'L' -> new_number += "5";
                case 'M', 'N', 'O' -> new_number += "6";
                case 'P', 'Q', 'R', 'S' -> new_number += "7";
                case 'T', 'U', 'V' -> new_number += "8";
                case 'W', 'X', 'Y', 'Z' -> new_number += "9";
                default -> new_number += num;
            }
        }
        number = Long.parseLong(new_number);

        // Return actual number only at the end of the function
        return number;

    }// End of full_number function
}
