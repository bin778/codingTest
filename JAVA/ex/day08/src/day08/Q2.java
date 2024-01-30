package day08;

import java.util.Scanner;

public class Q2 {
	public static void space(int space) {
		if(space == 0)
			return;
		System.out.print(" ");
		space(space - 1);
	}
	
	public static void star(int star) {
		if(star == 0)
			return;
		System.out.print("* ");
		star(star - 1);
	}
	
	public static void print(int n, int max) {
		if(n == 0)
			return;
		space(n - 1);
		star(max - n);
		System.out.println();
		print(n - 1, max);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력: ");
		int num = Integer.parseInt(sc.nextLine());
		
		print(num, num + 1);
	}
}
