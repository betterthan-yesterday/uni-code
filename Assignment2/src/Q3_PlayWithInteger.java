/* Assignment 2 (100 marks in total; 5% of the final score of this course)
 *
 * Question 3 (20 marks)
    Write a Java program that accepts an integer (n, 0 <= n <= 9) and computes the value of n+nn+nnn.

 * INPUT: a user input integer n
 * OUTPUT: the value of n+nn+nnn.

* Hint: For n=2, the output is 2+22+222=246
 */

import java.util.Scanner;

public class Q3_PlayWithInteger {
    public static void main(String[] args) {
        /* place your code here */

        // Get n integer input
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an int between 0 and 9 inclusive: ");
        int n = input.nextInt();
        int sum = n*111 + n*11 + n;

        System.out.println("The sum of n+nn+nnn is " + sum);
    }
}
