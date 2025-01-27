class NodeType:
  def __init__(self, item):
    self.data = item
    self.link = None

  # 연결 리스트와 다른 점은 노드를 생성할 때 마지막 노드를 처음 노드에 연결 시켜주는 것이다.
  def first_node_in(self, item):
    new_node = NodeType(item)
    if self.link is None:
      self.link = new_node
      new_node.link = self
    else:
      new_node.link = self.link
      self.link = new_node

  def first_node_out(self):
    if self.link is None:
      return None
    tmp = self.link
    self.link = tmp.link

  def last_node_in(self, item):
    new_node = NodeType(item)
    p = self
    if self.link is None:
      self.link = new_node
      new_node.link = self
    else:
      while p.link is not self:
        p = p.link
      p.link = new_node
      new_node.link = self

  def last_node_out(self):
    if self.link is None:
      return None
    p = self
    while p.link.link is not self:
      p = p.link
    p.link = self

  def print(self):
    string = f"{self.data} | "
    p = self.link
    while p is not self:
      string += f"{p.data} | "
      p = p.link
    string += p.data
    print(string)
