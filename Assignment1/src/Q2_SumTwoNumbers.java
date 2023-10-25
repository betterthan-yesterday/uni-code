/* Assignment 1 (100 marks in total; 5% of the final score of this course) 
 * 
 * Question 2 (20 marks)
 * 
 * Write a Java program to print the sum of two user input integer numbers.
 * Also submit a screenshot to demonstrate that you have successfully ran
 * javac and java commandline to compile and run the code of Q1_HelloWorld.java
 * 
 * INPUT: two user input integer numbers
 * OUTPUT: the sum of the two user input integer numbers
 * 
 * Hint1: you may use java.util.Scanner to take user input numbers.
 * 
 */

import java.util.Scanner;


public class Q2_SumTwoNumbers {
	public static void main(String[] args) {
		/* Place your code here */

		// User input
		Scanner input = new Scanner(System.in);
		System.out.print("Enter two ints: ");
		int val1 = input.nextInt();
		int val2 = input.nextInt();

		// Sum Calculation
		int sum = val1 + val2;

		System.out.printf("The sum of the two ints is %d. \n", sum);
	}
}
