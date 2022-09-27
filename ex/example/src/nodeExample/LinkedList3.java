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
		Node3 L = null, tmp;
		String[] name = {"Kim", "Lee", "Park", "Song"};
		int len = name.length;	// 배열의 크기는(정수형) ==> Integer.BYTES
		
		System.out.println("리스트 출력");
		for(int i = 0; i < len; i++) {
			tmp = new Node3();
			tmp.data = name[i];
			if(L == null) {
				L = tmp;	
			} else {
				link = tmp;
			}
			// 데이터 원소 출력
			System.out.print(tmp.data + " -> ");
		}
		System.out.println("null");
	}
}
