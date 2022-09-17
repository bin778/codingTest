package day03;

import java.util.NoSuchElementException;

public class ArrList<E> {
	private E a[];
    private int size; // 리스트의 항목 수

    // 배열 리스트
    public ArrList() { // 생성자
    	a = (E[])new Object[1]; // 1개의 원소를 가지는 배열
    	size = 0; // 항목을 0으로 초기화
    }
    
    // 연결(링크) 리스트
    public class ListNode {
        private int data; // 실제 노드
        private ListNode next; // 리스트 노드
        public ListNode(int data) {  }
    }
    
    public E peek(int k) { // k번째 저장된 항목을 검색, a[k]
    	if(size == 0) { // 항목(X)
    		throw new NoSuchElementException(); // 프로그램 stop
    	}
    	return a[k];
    }
    
    
}
