def bfs(graph, startNode):
  visited = [] # 방문한 노드들을 저장하는 리스트
  needVisit = [] # BFS에서 차례대로 방문해야 할 노드를 저장하는 리스트

  # 3. 시작 노드(startNode) needVisit 리스트에 넣는다.
  needVisit.append(startNode)

  while len(needVisit) != 0:
    # 4. needVisit에서 맨 앞에 있는 노드부터 꺼낸다.
    node = needVisit.pop(0)
    # 5. 이미 방문한 노드인지 확인하고, 
    if not node in visited:
      # 6. 방문하지 않으면 해당 노드와 연결된 모든 인접 노드 visited 리스트에 추가한다. 
      visited.append(node)
      needVisit.extend(graph[node])

  return visited

# 1. 인접 그래프 리스트를 선언하고 초기화한다.
graph = [[1, 2, 4], [0, 5], [0, 5], [4], [0, 3], [1, 2]]
# 2. 시작 노드(startNode)를 0으로 잡으며 BFS를 수행한다.
print(bfs(graph, 0))