class Tree:
  def __init__(self, value):
    # 트리의 Node를 생성하며, 자식 노드를 담을 리스트를 초기화한다.
    self.value = value
    self.children = []

  def insert_node(self, value):
    # 새로운 자식 노드를 생성하여 children에 추가한다.
    child_node = Tree(value)
    self.children.append(child_node)

  def contains(self, value):
    # 현재 노드의 값이 찾고자 하는 값과 일치하는지 확인한다.
    if self.value == value:
      return True
    
    # 자식 노드를 순회하며 값이 존재하는지 확인한다.
    for child_node in self.children:
      if child_node.contains(value):
        return True
    
    # 모든 자식 노드를 탐색해도 값이 없으면 False를 반환한다.
    return False
