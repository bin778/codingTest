package day04;

public class LinkedNodeList {
	// private을 선언 안했을 때 같은 패키지에서 접근 가능
		public class LinkedListNode2<E> {
			  E data;
			  LinkedListNode2<E> next;	  
		}
	
	// private을 선언 했을 때 같은 클래스 내에서만 접근 가능(은닉화 가능)
	// LinkedListNode의 구조 선언
	public class LinkedListNode<E> {
		  private E data; // 데이터를 참조
		  private LinkedListNode<E> next; // 다음 노드를 참조
		  // --> 자기 자신과 같은 자료형의 인스턴스를 가리킨다
		  
		  LinkedListNode(E data, LinkedListNode<E> next) {
			  this.data = data;
			  this.next = next;
		  }
	}
	
	public class LinkedList<E> {
		// 내부 클래스 --> Node class 내에서만 접근 가능
		// Node class 구조 선언
		class Node<E> { 
			private E data;
			private Node<E> next;
			
			Node(E data, Node<E> next) {
				  this.data = data;
				  this.next = next;
			}
		}
		private Node<E> head; // 헤드 노드
		private Node<E> crnt; // 현재 노드
		
		public LinkedList() {
			head = crnt = null; // head = null; crnt = null;
		}
		
		// 노드 삽입
		public void addFirst(E obj) {
			Node<E> p = head; // 헤더 노드 p 초기화
			head = crnt = new Node<E>(obj, p); // 첫 번째 노드를 삽입한다
		}
		
		public void addLast(E obj) {
			// 헤더 노드가 비어있으면 첫 번째 노드 삽입
			if(head == null) 
				addFirst(obj); // 첫 번째 노드 삽입 함수
			else {
				Node<E> p = head; // 헤더 노드 p 초기화
				// while문을 돌려서 다음 노드가 비어있으면 삽입
				while(p.next != null)
					p = p.next;
				p.next = crnt = new Node<E>(obj, null);
			}
		}
		
		// 노드 삭제
		public void removeFirst() {
			if(head != null) 
				head = crnt = head.next;
		}
		
		public void removeLast() {	
			if(head != null)
				if(head.next == null)
					removeFirst();
			else {
				Node<E> p = head;
				Node<E> p1 = head;
				while(p.next != null) {
					p1 = p;
					p = p.next;
				}
				p1.next = null;
				crnt = p1;
			}
		}
		
	}
}
