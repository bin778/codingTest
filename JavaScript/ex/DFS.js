function dfs(graph, v, visited) {
  // 현재 노드를 방문 처리(true)
  visited[v] = true;
  console.log(v);

  // 현재 노드와 연결된 다른 노드를 방문(재귀 함수 활용)
  for (let node of graph[v]) {
    // 방문한 노드인지 확인(탐색할 노드가 없으면 이전 노드로 되돌아간다)
    if (!visited[node]) { 
      dfs(graph, node, visited);
    }
  }
}

const graph = [[1, 2, 4], [0, 5], [0, 5], [4], [0, 3], [1, 2]];
const visited = Array(graph.length).fill(false);

dfs(graph, 0, visited);