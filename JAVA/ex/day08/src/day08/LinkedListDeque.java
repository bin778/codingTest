package day08;

public class LinkedListDeque {
	private class Node {
		Object data = null;
		Node next = null;

		Node(Object data) {
			this.data = data;
		}

		private Object getValue() {
			return data;
		}
	}

	private Node front = null;
	private Node rear = null;

	public void addFirst(Object data) {
		Node node = new Node(data);
		if (front == null) {
			front = node;
			rear = front;
			return;
		}

		Node temp = front;
		front = node;
		front.next = temp;
	}

	public void addLast(Object data) {
		Node node = new Node(data);
		if (front == null) {
			front = node;
			rear = front;
			return;
		}

		rear.next = node;
		rear = rear.next;
	}

	public Object removeFirst() {
		if (front == null) {
			System.out.println("삭제 할 데이터가 없음");
			return null;
		}
		Object value = front.getValue();
		front = front.next;
			
		return value;
	}

	public Object removeLast() {
		if (rear == null) {
			System.out.println("삭제 할 데이터가 없음");
			return null;
		}
		Object value = rear.getValue();

		Node temp = front;
		while (temp != null) {
			if (temp.next != rear) {
				temp = temp.next;
				continue;
			}

			rear = temp;
			rear.next = null;
		}
		
		if(front == rear) {
			front = null;
			rear = null;
		}
		return value;
	}

	public String print() {
		if (front == null) {
			return "deque empty";
		}
		String datas = "";
		Node temp = front;
		
		for( ; temp.next != null; temp = temp.next) {
			datas += String.format("%s->", temp.getValue());
		}
		datas += String.format("%s->", temp.getValue());
		return datas;
	}
}

