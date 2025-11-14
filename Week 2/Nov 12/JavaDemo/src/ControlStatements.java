package src;
/* Assignment: 
*	Take input from command line or scanner and practice the following control
*	statements:
*		if: input three numbers, find the largest of them
*		switch/case: input 1-7 use switch case to print the day of the week
*		while: take a number as input and display times table of that number
*		do-while:
* 		for: implement staircase and number stairs
*/
import java.util.Scanner;

public class ControlStatements {

	// Input three numbers, find the largest of them
	private static int practiceIf() {
		Scanner input = new Scanner(System.in);

		System.out.print("Enter a number: ");
		int num1 = Integer.parseInt(input.next());

		System.out.print("Enter a number: ");
		int num2 = Integer.parseInt(input.next());

		System.out.print("Enter a number: ");
		int num3 = Integer.parseInt(input.next());
		input.close();

		if (num1 > num2)
			return num1 > num3 ? num1 : num2;
		else if (num2 > num3)
			return num2;
		else
			return num3;

	}

	// Input 1-7 use switch case to print the day of the week
	private static void practiceSwitchCase(int num) {
		switch (num) {
			case 1:
				System.out.println("Sunday");
				break;
			case 2:
				System.out.println("Monday");
				break;
			case 3:
				System.out.println("Tuesday");
				break;
			case 4:
				System.out.println("Wednesday");
				break;
			case 5:
				System.out.println("Thursday");
				break;
			case 6:
				System.out.println("Friday");
				break;
			case 7:
				System.out.println("Saturday");
				break;
			default:
				System.out.println("Invalid Input Value");

		}
	}

	// Take a number as input and display times table of that number
	public static void practiceWhile(int num) {
		int i = 0;
		while (i <= 10) {
			System.out.println(num + " x " + i + " = " + (i * num));
			i++;
		}
	}

	private static void printUp(int height) {
		for (int i = 1; i <= height; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print('*');
			}
			System.out.println();
		}
	}

	private static void printDown(int height) {
		for (int i = height - 1; i > 0; i--) {
			for (int j = 1; j <= i; j++)
				System.out.print("*");
			System.out.println();
		}

	}

	private static void printNumeric(int height) {
		for (int i = 1; i <= height; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(j);
			}
			System.out.println();
		}
	}

	public static void practiceFor() {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the size of the staircase: ");
		int height = Integer.parseInt(input.next());
		input.close();
		printUp(height);
		printDown(height);
		printNumeric(height);
	}

	public static void main(String... args) {
		int num = Integer.parseInt(args[0]);
		// System.out.println("The largest number is: " + practiceIf());
		// practiceSwitchCase(num);
		// practiceWhile(num);
		// practiceFor(num);
	}
}
