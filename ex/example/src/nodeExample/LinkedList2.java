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
			int i;
			Node2 L = null, end;
			Node2 tmp1 = new Node2();
			end = L; // 마지막 노드를 가리키는 변수
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			String s = sc.next();
			if(s.equals("*"))
				break;
			tmp1 = new Node2();
			tmp1.data = s;
		}
		
	}
		
}
