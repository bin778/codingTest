class Node:
  def __init__(self, val):
    self.val = val
    self.next = None
    self.prev = None


class DoublyLinkedList:
  def __init__(self):
    self.head = None
    self.tail = None
    self.length = 0

  def push(self, val):
    # 인수로 전달된 값으로 새 노드를 만든다.
    new_node = Node(val)
    # 길이가 0이면, 새 노드를 head와 tail로 정한다.
    if self.length == 0:
      self.head = new_node
      self.tail = new_node
    else:
      # 길이가 0이 아니라면, tail의 next 포인터가 새 노드를 가리키게 하고,
      # 새 노드의 prev 포인터는 tail을 가리키게 하고,
      # 마지막으로 tail은 이제 새 노드가 되도록 지정한다.
      self.tail.next = new_node
      new_node.prev = self.tail
      self.tail = new_node
    self.length += 1
    return self

  def pop(self):
    # 만약 head가 없으면(=길이가 0이면) None을 반환한다.
    if not self.head:
      return None
    # popped_node 변수가 tail을 가리키게 한다.
    popped_node = self.tail
    # 길이가 1이면, head와 tail 모두 None이 된다.(pop됐으니)
    if self.length == 1:
      self.head = None
      self.tail = None
    else:
      # 길이가 2이상이면, popped_node의 prev(마지막에서 두 번째) 노드가 tail이 되도록 하고,
      # tail의 next 포인터는 None으로 재할당하고,
      # popped_node의 prev 포인터도 None으로 재할당하여 연결을 끊는다.
      self.tail = popped_node.prev
      self.tail.next = None
      popped_node.prev = None
    self.length -= 1
    return popped_node

  def shift(self):
    # 길이가 0이면, None을 반환한다.
    if self.length == 0:
      return None
    # old_head 변수가 head를 가리키게 한다.
    old_head = self.head
    # 길이가 1이면, shift될 경우 길이가 0이 되므로 head와 tail에 모두 None을 할당한다.
    if self.length == 1:
      self.head = None
      self.tail = None
    else:
      # 길이가 2이상이면, old_head의 next(앞에서 두 번째) 노드가 head가 되도록 하고,
      # head의 prev 포인터는 None으로 재할당하고,
      # old_head의 next 포인터도 None으로 재할당하여 연결을 끊는다.
      self.head = old_head.next
      self.head.prev = None
      old_head.next = None
    self.length -= 1
    return old_head

  def unshift(self, val):
    # 인수로 받은 val로 새 노드를 만든다.
    new_node = Node(val)
    # 길이가 0이면, head와 tail에 모두 새 노드를 할당한다.
    if self.length == 0:
      self.head = new_node
      self.tail = new_node
    else:
      # 길이가 1 이상이면, head의 prev 포인터가 새로 추가된 노드를 가리키게 하고,
      # 새 노드의 next 포인터는 head를 가리키게 하고,
      # 이제 새 노드가 head가 되도록 만든다.
      self.head.prev = new_node
      new_node.next = self.head
      self.head = new_node
    self.length += 1
    return self

  def get(self, index):
    # 입력된 인덱스가 유효한지 체크한다.
    if index < 0 or index >= self.length:
      return None
    count = 0
    current = None
    # 입력된 인덱스가 리스트의 앞 부분에 있으면
    if index <= self.length // 2:
      current = self.head
      # head부터 시작해서 정방향으로 루프를 돈다.
      while count != index:
        current = current.next
        count += 1
    # 입력된 인덱스가 리스트의 뒤 부분에 있으면,
    else:
      current = self.tail
      # tail부터 시작해서 역방향으로 루프를 돈다.
      count = self.length - 1
      while count != index:
        current = current.prev
        count -= 1
    return current

  def set(self, index, val):
    # get 메서드를 사용하여 found_node가 해당 인덱스의 노드를 가리키도록 한다.
    found_node = self.get(index)
    # 입력된 값을 found_node의 val에 재할당하고 True를 반환한다.
    if found_node:
      found_node.val = val
      return True
    return False

  def insert(self, index, val):
    # 입력된 인덱스가 유효한지 체크한다.
    if index < 0 or index > self.length:
      return False
    # 입력된 인덱스가 길이와 같다면, push 메서드 사용하고 형 변환을 통해 True를 반환한다.
    if index == self.length:
      return bool(self.push(val))
    # 입력된 인덱스가 0이라면, unshift 메서드 사용하고 형 변환을 통해 True를 반환한다.
    if index == 0:
      return bool(self.unshift(val))

    new_node = Node(val)
    # 새로 삽입될 노드의 이전에 위치할 노드는 get 메서드를 사용해서 index-1 노드를 가져오고, 새로 삽입될 노드의 다음에 위치할 노드는 before_node의 next를 통해 가져온다.
    before_node = self.get(index - 1)
    after_node = before_node.next

    # before_node의 next 포인터가 새 노드를 가리키게 하고, 새 노드의 prev 포인터는 before_node를 가리키게 한다.
    before_node.next = new_node
    new_node.prev = before_node
    # 새 노드의 next 포인터가 after_node를 가리키게 하고, after_node의 prev 포인터는 새 노드를 가리키게 한다.
    new_node.next = after_node
    after_node.prev = new_node
    self.length += 1
    return True

  def remove(self, index):
    # 입력된 인덱스가 유효한지 체크한다.
    if index < 0 or index >= self.length:
      return None
    # 입력된 인덱스가 0이면 shift 메서드를 사용한다.
    if index == 0:
      return self.shift()
    # 입력된 인덱스가 끝 인덱스와 같다면 pop 메서드를 사용한다.
    if index == self.length - 1:
      return self.pop()

    # 삭제할 노드의 인덱스를 탐색한다.
    removed_node = self.get(index)
    # 삭제할 노드의 이전 노드의 next 포인터가 삭제할 노드의 next 노드를 가리키게 한다.
    removed_node.prev.next = removed_node.next
    # 삭제할 노드의 다음 노드의 prev 포인터가 삭제할 노드의 prev 노드를 가리키게 한다.
    removed_node.next.prev = removed_node.prev

    # 삭제할 노드의 next 포인터와 prev 포인터를 모두 None으로 재할당하여, 연결을 끊는다.
    removed_node.next = None
    removed_node.prev = None
    self.length -= 1
    return removed_node

  def reverse(self):
    # 반복문에서 사용할 node를 저장한다.
    node = self.head
    # head와 tail을 바꾼다.
    self.head = self.tail
    self.tail = node

    # next 포인터 방향 뒤집기
    next_node = None
    prev_node = None
    for _ in range(self.length):
      next_node = node.next
      node.next = prev_node
      prev_node = node
      node = next_node

    # prev 포인터 방향 뒤집기 (위에서 head와 tail이 뒤집혔으므로 self.head는 사실상 원래 tail이었다)
    next_node = None
    node = self.head
    for _ in range(self.length):
      prev_node = node.prev
      node.prev = next_node
      next_node = node
      node = prev_node
