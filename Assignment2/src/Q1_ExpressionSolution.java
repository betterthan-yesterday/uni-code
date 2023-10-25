/* Assignment 2 (100 marks in total; 5% of the final score of this course)
 *
 * Question 1 (20 marks)
    Write a Java program to find the value of following expression.
    a) (101 + 0) / 3
    b) 3.0e-6 * 10000000.1
    c) true && true
    d) false && true
    e) (false && false) || (true && true)
    f) (false || false) && (true && true)

 * INPUT: n/a
 * OUTPUT: the value of each of the above expressions.

 */


public class Q1_ExpressionSolution {
    public static void main(String[] args) {
        /* Place your code here */
        // Instantiating expressions
        float a = (101 + 0) / 3;
        double b = 3.0e-6 * 10000000.1;
        boolean c = true && true;
        boolean d = false && true;
        boolean e = (false && false) || (true && true);
        boolean f = (false || false) && (true && true);

        // Output
        System.out.println("This expression (101 + 0) / 3 outputs " + a);
        System.out.println("This expression 3.0e-6 * 10000000.1 outputs " + b);
        System.out.println("This expression true && true outputs " + c);
        System.out.println("This expression false && true outputs " + d);
        System.out.println("This expression (false && false) || (true && true) outputs " + e);
        System.out.println("This expression (false || false) && (true && true) outputs " + f);
    }
}
