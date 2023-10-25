/* Assignment 1 (100 marks in total; 5% of the final score of this course) 
 * 
 * Question 4 (20 marks)
 * 
 * Write a Java program to print the area and perimeter of a circle.
 * Also submit a screenshot to demonstrate that you have successfully ran
 * javac and java commandline to compile and run the code of Q1_HelloWorld.java
 * 
 * INPUT: radius input by a user.
 * OUTPUT: the area and the perimeter of the circle defined by the radius. All results must use two significant digits after decimal point.
 * 
 * Hint: you may use java.util.Scanner to take user input real valued radius.
 * 
 */

import java.util.Scanner;

public class Q4_AreaOfCircle {
	public static void main(String[] args) {
		/* Place your code here */

		// User input
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a radius: ");
		float radius = input.nextFloat();

		// Area and circumference calculation
		double pi = 3.14159;
		double area = pi * radius * radius;
		double circum = 2 * pi * radius;

		System.out.printf("The area is %.2f and the perimeter is %.2f. \n", area, circum);
	}
}
