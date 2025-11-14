package src;

import java.util.Scanner;

public class ScannerDemo {
	public static void main(String []args){
		String firstName;
		Scanner input = new Scanner(System.in);
		System.out.print("Enter your name: ");
		firstName = input.next();
		System.out.println("Hello" + firstName);
	}
}