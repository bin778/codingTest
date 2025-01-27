# Node 구현
class Node:
  def __init__(self, element):
    self.element = element
    self.next = None


# Linked List 구현
class LinkedList:
  def __init__(self):
    self.head = Node("head")
    self.find = self.find
    self.append = self.append
    self.insert = self.insert
    self.remove = self.remove
    self.toString = self.toString
    self.findPrevious = self.findPrevious

  # 노드 찾기
  def find(self, item):
    curr_node = self.head
    while curr_node.element != item:
      curr_node = curr_node.next
    return curr_node

  # 이전 노드 찾기
  def findPrevious(self, item):
    curr_node = self.head
    while curr_node.next is not None and curr_node.next.element != item:
      curr_node = curr_node.next
    return curr_node

  # 노드 추가
  def append(self, new_element):
    new_node = Node(new_element)  # 새로운 노드 생성
    current = self.head  # 시작 노드
    while current.next is not None:
      # 맨 끝 노드 찾기
      current = current.next
    current.next = new_node

  # 노드 중간 삽입
  def insert(self, new_element, item):
    new_node = Node(new_element)  # 새로운 노드 생성
    current = self.find(item)  # 삽입할 위치의 노드 찾기
    new_node.next = current.next  # 찾은 노드가 가리키는 노드를 새로운 노드가 가리키기
    current.next = new_node  # 찾은 노드는 이제부터 새로운 노드를 가리키도록 하기

  # 노드 삭제
  def remove(self, item):
    pre_node = self.findPrevious(item)  # 삭제할 노드를 가리키는 노드 찾기
    pre_node.next = pre_node.next.next  # 삭제할 노드 다음 노드를 가리키도록 하기

  # 연결 리스트의 요소들을 출력
  def toString(self):
    str_ = "[ "
    curr_node = self.head
    while curr_node.next is not None:
      str_ += curr_node.next.element + " "
      curr_node = curr_node.next
    return str_ + "]"
