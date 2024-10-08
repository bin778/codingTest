function bfs(graph, startNode) {
  let visited = []; // 탐색을 마친 노드들
  let needVisit = []; // 탐색해야할 노드들

  needVisit.push(startNode); // 노드 탐색 시작

  while (needVisit.length !== 0) { // 탐색해야할 노드가 남아있다면
    const node = needVisit.shift(); // 가장 오래 남아있던 정점을 뽑아냄.
    if (!visited.includes(node)) { // 해당 노드 방문이 처음이라면,
      visited.push(node);
      needVisit = [...needVisit, ...graph[node]];
    }
  }

  return visited;
};

const graph = [[1, 2, 4], [0, 5], [0, 5], [4], [0, 3], [1, 2]];
console.log(bfs(graph, 0));