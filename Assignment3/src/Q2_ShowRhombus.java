/* Assignment 3 (100 marks in total; 5% of the final score of this course)
 *
 * Question 2 (20 marks)
    Write a java program to display the number rhombus structure.

 * INPUT: user input integer value: n
 * The input should be fed into a subroutine as parameter.
 *
 * OUTPUT: the rhombus structure corresponding to n. (see the following example)
 * Your subroutine should directly print the result and do not return anything.

*
* Example:
* For n=7, the rhombus structure is:
      1
     212
    32123
   4321234
  543212345
 65432123456
7654321234567
 65432123456
  543212345
   4321234
    32123
     212
      1

* For n=3, the rhombus structure is:
  1
 212
32123
 212
  1

 */

import java.util.Scanner;

public class Q2_ShowRhombus {
    /* place your subroutine code here */
    public static void rhombus(int n) {

        String[] past_str = new String[n - 1];
        for (int i = 1; i <= n; i++) {
            String str_1 = "";
            for (int j = i; j < n; j++) {
                str_1 += " ";
            }

            for (int j = i; j >= 1; j--) {
                str_1 += String.format("%d", j);
            }

            for (int j = 1; j <= i - 1; j++) {
                str_1 += String.format("%d", j+1);
            }
            ;
            if (i != n) { past_str[n - i - 1] = str_1; }
            System.out.println(str_1);
        }

        for (String str : past_str) 
            System.out.println(str);
    }

    public static void main(String args[])  {
        /* place your code to run your subroutine here */
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        rhombus(input.nextInt());
    }
}
