package nodeExample;

import java.util.Scanner;

public class LinkedList4 {
	public static void main(String[] args) {	
		Node4 obj = new Node4();
		obj.makeN();
	}
}

class Node4 {
	Object data;
	Node4 link;
	void makeN() {
		Node4 L = null, tmp, end;
		end = L;
		Scanner sc = new Scanner(System.in);
		int element, sequence;
		
		int[] data = {15, 35, 67, 87};
		int len = data.length;
		
		for(int i = 0; i < len; i++) {
			tmp = new Node4();
			tmp.data = data[i];
			if(L == null) {
				L = tmp;
				end = L;
			} else {
				link = tmp;
				end = tmp;
			}
		}
		System.out.println("리스트 출력");
		L.printList(L);
		
		System.out.println("원소 입력");
		element = Integer.parseInt(sc.nextLine());
		System.out.println("들어갈 번호 입력");
		sequence = Integer.parseInt(sc.nextLine());
		
		
	}
	
	void printList(Node4 d) {
		while(d != null) {
			System.out.print(d.data + " -> ");
			d = d.link;
		}
		System.out.println("null");
	}
	
}
