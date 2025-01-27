def dfs(graph, v, visited):
  visited[v] = True # 3. 방문한 정점(v)은 True로 처리한다.
  print(v) # 4. 현재 방문한 정점(v)을 출력한다.

  # 5. 현재 정점(v)과 연결된 모든 이웃 정점들을 확인한다.
  # ex) v = 0이면, 이웃 정점인 1, 2, 4를 확인
  for node in graph[v]: 
    # 6. 아직 방문하지 않는 이웃 정점이면 재귀 호출하여 DFS를 계속 수행한다.
    if not visited[node]:
      dfs(graph, node, visited)

# 1. 인접 그래프 리스트, 방문 리스트를 선언하고 초기화한다.
graph = [[1, 2, 4], [0, 5], [0, 5], [4], [0, 3], [1, 2]]
visited = [False] * len(graph)
# 2. 초기 정점 (v)을 0으로 잡으며 DFS를 수행한다.
dfs(graph, 0, visited)