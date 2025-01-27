# add_front() 덱의 front에 item을 추가하는 메서드
# delete_front() 덱의 front에 있는 item을 반환한다.
# add_rear() 덱의 rear에 item을 추가하는 메서드
# delete_rear() 덱의 rear에 있는 item을 반환한다.

class DeckType:
  def __init__(self, size):
    self.max_queue_size = size
    self.array = [None] * size
    self.front = 0
    self.rear = 0

  def is_empty(self):
    return self.front == self.rear

  def is_full(self):
    return (self.rear + 1) % self.max_queue_size == self.front

  def add_front(self, item):
    if self.is_full():
      print("큐가 포화상태입니다.")
    else:
      self.array[self.front] = item
      self.front = (self.front - 1 + self.max_queue_size) % self.max_queue_size

  def delete_front(self):
    if self.is_empty():
      print("큐가 비었습니다.")
    else:
      prev = self.front
      self.front = (self.front + 1) % self.max_queue_size
      return self.array[prev]

  def add_rear(self, item):
    if self.is_full():
      print("큐가 포화상태입니다.")
    else:
      self.rear = (self.rear + 1) % self.max_queue_size
      self.array[self.rear] = item

  def delete_rear(self):
    if self.is_empty():
      print("큐가 비었습니다.")
    else:
      prev = self.rear
      self.rear = (self.rear - 1 + self.max_queue_size) % self.max_queue_size
      return self.array[prev]

  def print(self):
    if self.is_empty():
      print("큐가 비었습니다.")
    else:
      string = ""
      i = self.front
      while True:
        i = (i + 1) % self.max_queue_size
        string += str(self.array[i]) + "|"
        if i == self.rear:
          print(string)
          break
