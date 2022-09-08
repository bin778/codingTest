package arrayExample;

//사용자로 부터 입력받은 소문자 알파벳을 대문자로 변경하여 출력하는 소스를 코딩
//예] 'a'를 입력 받으면 'A'로 출력

import java.util.Scanner;

public class Ex3 {
	public static void main(String[] args) {
		
		char ch;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("소문자 입력 >> ");
		ch = sc.next().charAt(0);
		
		// 소문자(a~z)를 입력하면 ASCII 코드를 이용해 32를 뺀 값으로 문자형 값 출력
		if (ch >= 'a' && ch <= 'z')
			System.out.println("대문자 : " + (char)(ch - 32));
		else
			System.out.println("소문자를 입력해야 합니다.");
	}
}

