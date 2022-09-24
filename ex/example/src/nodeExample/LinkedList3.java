package nodeExample;
	
public class LinkedList3 {
	public static void main(String[] args) {	
		Node3 obj = new Node3();
		obj.makeN();
	}
}

class Node3 {
	Object data;
	Node3 link;
	void makeN() {
		Node3 L = null, tmp, end;
		end = L; // 마지막 노드를 가리키는 변수
		
		String[] name = {"Kim", "Lee", "Park", "Song"};
		int len = name.length;	// 배열의 크기는(정수형) ==> Integer.BYTES
		
		for(int i = 0; i < len; i++) {
			tmp = new Node3();
			tmp.data = name[i];
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
	}
	
	void printList(Node3 d) {
		while(d != null) {
			System.out.print(d.data + " -> ");
			d = d.link;
		}
		System.out.println("null");
	}
}