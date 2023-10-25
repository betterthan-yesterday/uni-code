/* Assignment 3 (100 marks in total; 5% of the final score of this course)
 *
 * Question 1 (20 marks)
    Write a Java program, use 'subroutine', 'if', 'else if' and 'else' to solve a quadratic equation in the following form:

    a*x^2 + b*x + c = 0

 * INPUT: user input real valued coefficients: a, b, c.
 * These inputs should be fed as parameters into a subroutine that you write.
 *
 * OUTPUT: Output the solutions (i.e., roots) to the quadratic function defined by the coefficients a, b and c.
 * If there is no real roots, output: "The equation has no real roots."
 * The above outputs should be produced as a String variable returned by your subroutine.
 *
 * Note: all values must be displayed using two significant digits after decimal point.

*
* Example:
For a=1, b=5 and c=2, the roots are -0.44 and -4.56
 */

import java.util.Scanner;

public class Q1_SolveQuadraticEquation {
    /* place your subroutine code here */
    public static String solve(float a, float b, float c) {

        String result;
        float discriminant = b*b - 4*a*c;

        if (discriminant < 0) {
            result = "The equation has no real roots.";
        } else if (discriminant > 0) {
            double root_1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root_2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            result = String.format("The two roots are %.2f and %.2f. \n", root_1, root_2);
        } else {
            double root = (-b / 2 * a);
            result = String.format("The one root is %.2f. \n", root);
        }

        return result;
    }

    public static void main(String[] Strings) {
        /* place your code to run your subroutine here */
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the coefficients of the quadratic equation: ");
        float a = input.nextFloat();
        float b = input.nextFloat();
        float c = input.nextFloat();

        System.out.println(solve(a, b, c));
    }
}
