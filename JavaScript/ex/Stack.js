// 사실 자바스크립트에서는 push(), pop()이 메서드가 있어 별도의 알고리즘을 구현할 필요가 없다.
// 스택은 top에 바로 접근 가능하기 때문에 삽입, 삭제의 시간 복잡도는 O(1)이다. top은 가장 끝쪽에 위치한 데이터를 가리키며 push는 top에 새로운 데이터를 추가하고, pop은 top을 추출한다.

class Stack {
  constructor() {
    this.storage = new Object();
    this.size = 0;
  }

  push(element) {
    this.size++;
    this.storage[this.size] = element;
  }

  pop() {
    let removed = this.storage[this.size];
    delete this.storage[this.size];
    this.size--;
    return removed;
  }

  top() {
    return this.storage[this.size];
  }
}
