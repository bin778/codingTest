package nodeExample;

import java.util.Scanner;

public class LinkedList2 {
	public static void main(String[] args) {	
		Node2 obj = new Node2();
		obj.makeN();
	}
}

class Node2 {
		Object data;
		Node2 link;
		void makeN() {
			Node2 L = null, end;
			Node2 tmp1 = new Node2();
			end = L; // 마지막 노드를 가리키는 변수
		
		System.out.print("정수 입력(마침 문자는 *) --> ");
		Scanner sc = new Scanner(System.in);
		while(true) {
			String s = sc.next();
			if(s.equals("*"))
				break;
			tmp1 = new Node2();
			tmp1.data = s;
			System.out.print(tmp1.data + " -> ");
		}
		System.out.println("null");
	}	
}
