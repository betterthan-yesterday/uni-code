/* Assignment 4 (100 marks in total; 5% of the final score of this course)
 *
 * Question 2 (20 marks)
 *
 * Use a "subroutine" and a lambda expression to implement function
 * f(x,y) = sqrt(x*x-y*y), both x and y are real numbers.
 * Meanwhile, your code can throw an IllegalException (custom run-time exception,
 * which can be one provided by Java) if the value of (x*x-y*y) is negative.
 *
 * INPUT: the value of x and y (user input)
 * OUTPUT: the value of sqrt(x*x-y*y)
 *
 * Note: output must be displayed using four significant digits after decimal point.
 *
 */

import java.util.Scanner;

public class Q2_LambdaExpression {
    /* place your subroutine code here */
    interface UserMath {
        double run(float x, float y);
    }

    static void calculate(float x, float y, UserMath function) {
        double result = function.run(x, y);
        System.out.printf("Output of sqrt(x*x-y*y) is %.4f", result);
    }

    public static void main(String[] args){
        /* place your code to run your subroutine here */
        UserMath func = ((x, y) -> Math.sqrt(x*x - y*y));

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter two real numbers: ");
        float x = scanner.nextFloat();
        float y = scanner.nextFloat();
        if (x*x < y*y) throw new ArithmeticException();

        calculate(x, y, func);
    }
}
