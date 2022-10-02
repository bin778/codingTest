package day08;

import java.util.Scanner;

public class Q1 {
	public static int power(int num1, int num2) {
		if (num2 == 0)
			return 1;
		else
			return num1 * power(num1, num2 - 1);
	}
	
	public static void main(String[] args) {
		int num1, num2;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("두 정수를 입력: ");
		num1 = Integer.parseInt(sc.nextLine());
		num2 = Integer.parseInt(sc.nextLine());
		
		int result = power(num1, num2);
		
		System.out.println("result = " + result);
	}
}
