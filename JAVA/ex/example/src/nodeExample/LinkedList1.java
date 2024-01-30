package nodeExample;

public class LinkedList1 {
	public static void main(String[] args) {
		Node L = new Node();
		L.data = "Kim";
		L.link = null;
		
		Node tmp = new Node();
		tmp.data = "Lee";
		L.link = tmp; // Kim뒤에 Lee 원소 연결
		
		Node tmp1 = new Node();
		tmp1.data = "Park";
		tmp.link = tmp1;
		
		Node tmp2 = new Node();
		tmp2.data = "Song";
		tmp1.link = tmp2;
		
		tmp2.link = null;
		System.out.println("리스트 출력");
		L.printList(L);
	}
}

class Node {
	Object data; // String 타입은 같은 값이면 공유할 수 있다.
	// 변수명은 stack 영역, 데이터는 heap 영역에 저장
	Node link; // 자기 자신을 참조하는 link
		
	void printList(Node d) {
		while(d != null) {
			System.out.print(d.data + " -> ");
			d = d.link;
		}
		System.out.println("null");
	}
}
