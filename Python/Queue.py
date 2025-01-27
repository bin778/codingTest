class Queue:
  def __init__(self):
    self.queue = []
  
  def push(self, x):
    self.queue.append(x)
  
  def pop(self):
    return self.queue.pop(0) if self.queue else -1

  def size(self):
    return len(self.queue)

  def empty(self):
    return not self.queue

  def front(self):
    return self.queue[0] if self.queue else -1

  def back(self):
    return self.queue[-1] if self.queue else -1