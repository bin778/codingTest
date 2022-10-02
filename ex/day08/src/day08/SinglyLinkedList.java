package day08;

public class SinglyLinkedList {
    private Node head;

    SinglyLinkedList() {
        this.head = null;
    }

    SinglyLinkedList(int value) {
        this.head = new Node(value, null);
    }

    class Node {
        private int value; 
        private Node next; 

        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        public int getValue() {
            return this.value;
        }
    }

    public Node getHead() {
        return this.head;
    }

    public void append(int value) {
        if (this.head == null) {
            this.head = new Node(value, null);
            return;
        }

        Node pointer = this.head;
        while (pointer.next != null) {
        	if (pointer.getValue() == value) {
        		System.out.println("중복 데이터 삽입 불가 : " + value);
        		return;
        	}
        	// 다음 노드에 데이터가 있을 때 검사한다.
            pointer = pointer.next;
        }
        if (pointer.getValue() == value) {
    		System.out.println("중복 데이터 삽입 불가 : " + value);
    		return;
    	}
        // 다음 노드가 null 값일 때 검사한다.
        pointer.next = new Node(value, null);
    }


    public void delete(int value) {
        Node pointer = this.head;


        if (pointer.getValue() == value) {
            Node removeNode = this.head;
            this.head = this.head.next;

            removeNode = null;
            return;
        }

        Node temp = pointer;

        while (pointer != null && pointer.getValue() != value) {
            temp = pointer;
            pointer = pointer.next;
        }


        if (pointer.next == null) {
            temp.next = null;
        } else {
            temp.next = pointer.next;
        }
        pointer = null;
    }

    public void printAll() {
        Node pointer = this.head;

        StringBuilder builder = new StringBuilder();
        while (pointer.next != null) {
            builder.append(pointer.getValue());
            builder.append(" -> ");
            pointer = pointer.next;
        }

        builder.append(pointer.getValue());
        System.out.println(builder.toString());
    }
}

