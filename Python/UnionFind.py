# 부모 노드를 찾는 함수
def get(x, parent):
  if parent[x] != x: parent[x] = get(parent[x], parent)
  return parent[x]

# 두 부모 노드를 연결하는 함수
def union(x, y, parent):
  a = get(x, parent)
  b = get(y, parent)

  if a < b: parent[b] = a
  else: parent[a] = b

# 같은 부모를 가지는지 확인
def find(x, y, parent):
  a = get(x, parent)
  b = get(y, parent)

  if a == b: return True
  else: return False
