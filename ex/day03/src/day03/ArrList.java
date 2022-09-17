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
    
    // 리스트의 삭제
    public E peek(int k) { // k번째 저장된 항목을 검색, a[k]
    	if(size == 0) { // 항목(X)
    		throw new NoSuchElementException(); // 프로그램 stop
    	}
    	return a[k];
    }
    
    // 리스트의 삽입
    public void insertLast(E newItem) {
    	if(size == a.length)
    		resize(2*a.length); // a의 사이즈를 2배로 늘린다.
    	a[size++] = newItem;
    }
    
    // resize() 메소드, 배열의 길이를 재정의
    public void resize(int newSize) {
    	// 배열 타입을 알 수 없기 때문에 Object로 정의
    	Object[] o = new Object[newSize];
    	// 새롭게 만든 배열의 길이를 for문으로 재정의한다
    	for (int i = 0; i < size; i++) 
    		o[i] = a[i];
    	a = (E[])o;
    }
    
}
