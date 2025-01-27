class MinHeap:
  def __init__(self):
    self.heap = []

  def size(self):
    return len(self.heap)

  def swap(self, idx1, idx2):
    self.heap[idx1], self.heap[idx2] = self.heap[idx2], self.heap[idx1]

  def get_parent_idx(self, child_idx):
    return (child_idx - 1) // 2

  def get_left_child_idx(self, parent_idx):
    return parent_idx * 2 + 1

  def get_right_child_idx(self, parent_idx):
    return parent_idx * 2 + 2

  def heappop(self):
    heap_size = self.size()
    if heap_size == 0:
      return None
    if heap_size == 1:
      return self.heap.pop()

    value = self.heap[0]
    self.heap[0] = self.heap.pop()
    self.bubbledown()
    return value

  def heappush(self, value):
    self.heap.append(value)
    self.bubbleup()
    return self.heap

  def bubbleup(self):
    child = self.size() - 1
    parent = self.get_parent_idx(child)

    while child > 0 and self.heap[child] < self.heap[parent]:
      self.swap(child, parent)
      child = parent
      parent = self.get_parent_idx(child)

  def bubbledown(self):
    parent = 0
    left_child = self.get_left_child_idx(parent)
    right_child = self.get_right_child_idx(parent)

    while (left_child < self.size() and self.heap[left_child] < self.heap[parent]) or \
          (right_child < self.size() and self.heap[right_child] < self.heap[parent]):

      if right_child < self.size() and self.heap[left_child] > self.heap[right_child]:
        self.swap(parent, right_child)
        parent = right_child
      else:
        self.swap(parent, left_child)
        parent = left_child

      left_child = self.get_left_child_idx(parent)
      right_child = self.get_right_child_idx(parent)
