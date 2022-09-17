package day03;

public class NodeList {
	public class ListNode {
    	private int data;
    	private ListNode next;
    	
    	// 생성자
    	public ListNode(int data) {
    		this.data = data;
    	}
    	
    	public void setData(int data) {
    		this.data = data;
    	}
    	
    	public int getData() {
    		return data;
    	}
    	
    	public void setNext(ListNode next) {
    		this.next = next;
    	}
    	
    	public ListNode getNext() {
    		return this.next;
    	}
    }
	
	// 리스트 탐색
	int ListLength(ListNode headNode) {
		int length = 0;
		ListNode currentNode = headNode;
		while(currentNode != null) {
			length++;
			currentNode = currentNode.getNext();
		}
		return length;
	}
	
	// 리스트 삽입
	ListNode InsertLinkedList(ListNode headNode, ListNode nodeToInsert, int position) {
		if(headNode == null) 
			return nodeToInsert;
		int size = ListLength(headNode);
		if(position > size + 1 || position < 1) { 
			System.out.println("노드를 삽입할 수 없습니다.");
			return headNode;
		}
		
		if(position == 1) {
			nodeToInsert.setNext(headNode);
			return nodeToInsert;
		} else {
			ListNode previousNode = headNode;
			int count = 1;
			while(count < position -1) {
				previousNode = previousNode.getNext();
				count++;
			}
			ListNode currenNode = previousNode.getNext();
			nodeToInsert.setNext(currenNode);
			previousNode.setNext(nodeToInsert);
		}
		return headNode;
	}
	
}
