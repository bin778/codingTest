// addRear() 덱의 rear에 item을 추가하는 메서드
// addFront() 덱의 front에 item을 추가하는 메서드
// deleteRear() 덱의 rear에 있는 item을 반환한다.
// deleteFront() 덱의 front에 있는 item을 반환한다.
class DeckType {
  constructor(size) {
    this.maxQueueSize = size;
    this.array = [];
    this.front = 0;
    this.rear = 0;
  }

  isEmpty() {
    return this.front == this.rear;
  }

  isFull() {
    return (this.rear + 1) % this.maxQueueSize == this.front;
  }

  addFront(item) {
    if (this.isFull()) {
      console.log(new Error("큐가 포화상태입니다."));
    } else {
      this.array[this.front] = item;
      this.front = (this.front - 1 + this.maxQueueSize) % this.maxQueueSize;
    }
  }

  deleteFront() {
    if (this.isEmpty()) {
      console.log(new Error("큐가 비었습니다."));
    } else {
      const prev = this.front;
      this.front = (this.front + 1) % this.maxQueueSize;
      return this.array[prev];
    }
  }

  addRear(item) {
    if (this.isFull()) {
      console.log(new Error("큐가 포화상태입니다."));
    } else {
      this.rear = (this.rear + 1) % this.maxQueueSize;
      this.array[this.rear] = item;
    }
  }

  deleteRear() {
    if (this.isEmpty()) {
      console.log(new Error("큐가 비었습니다."));
    } else {
      const prev = this.rear;
      this.rear = (this.rear - 1 + this.maxQueueSize) % this.maxQueueSize;
      return this.array[prev];
    }
  }

  print() {
    if (this.isEmpty()) {
      console.log(new Error("큐가 비었습니다."));
    }
    let string = "";
    let i = this.front;
    do {
      i = (i + 1) % this.maxQueueSize;
      string += this.array[i] + "|";
      if (i == this.rear) {
        console.log(string);
        break;
      }
    } while (i != this.rear);
  }
}
