package day04;

public class LinkedNodeList2<E> {
	public class ListNode {
		public Object data;
		public ListNode next;
		
		public ListNode() {
			this.data = null;
			this.next = null;
		}
		
		public ListNode(Object data, ListNode next) {
			this.data = data;
			this.next = next;
		}
		
		public String toString() {
			return "ListNode(" + data.toString() + ")";
		}
	}
	
	public class Node {
		public E data;
		public Node next;
		
		public Node (E data, Node Next) {
			this.data = data;
			this.next = this.next;
		}
	}
	
}
