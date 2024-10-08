// 신장 트리(Spanning Tree): 모든 노드가 간선으로 이루어져 있으면서 사이클이 없는 트리
// 사이클(Cycle): 시작 노드와 끝 노드까지 간선으로 연결된 상태
// 최소 신장 트리(Minimum Spanning Tree): 가장 적은 비용인 신장 트리

// 크루스칼 알고리즘(Kruskal's Algorithm)을 이용한 최소 신장 트리 구현 알고리즘
// 크루스칼 알고리즘은 모든 간선을 후보로 두고 가장 작은 비용의 간선부터 구하되 사이클이 발생하는 간선은 제외한다.
// 이는 모든 노드가 간선으로 이어질 때 까지 반복한다.
function MST(V, graph) {
  // 부모 테이블 상에서, 부모를 자기 자신으로 초기화
  const parent = new Array(V + 1).fill(0).map((_, i) => i);

  // 모든 간선을 담을 리스트와 최소 비용을 담을 변수 result
  const edges = [];
  let result = 0;

  // 모든 간선에 대한 정보 입력
  for (let i in graph) {
    // 비용, 간선A, 간선B
    edges.push([graph[i][2], graph[i][0], graph[i][1]]);
  }

  // 비용 기준으로 오름차순으로 정렬
  edges.sort((a, b) => a[0] - b[0]);

  // 특정 원소가 속한 집합을 찾는 함수
  function find_parent(parent, x) {
    // 루트 노드가 아니라면 루트 노드를 찾을 때까지 재귀 호출
    if (parent[x] !== x) parent[x] = find_parent(parent, parent[x]);
    return parent[x];
  }

  // 두 원소가 속한 집합 합치기
  function union_parent(parent, a, b) {
    a = find_parent(parent, a);
    b = find_parent(parent, b);
    if (a < b) parent[b] = a;
    else parent[a] = b;
  }

  // 간선을 하나씩 확인한다
  for (let i in edges) {
    const [cost, a, b] = edges[i];
    if (find_parent(parent, a) !== find_parent(parent, b)) {
      union_parent(parent, a, b);
      result += cost;
    }
  }

  return result;
}
