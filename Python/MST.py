import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**7)

# 연결할 노드와 연결할 수 있는 간선 입력
V, E = map(int, input().split())
parent = [0] * (V + 1)

# 부모 테이블 상에서, 부모를 자기 자신으로 초기화
for i in range(1, V + 1):
  parent[i] = i

# 모든 간선을 담을 리스트와 최소 비용을 담을 변수 result
edges = []
result = 0

# 모든 간선에 대한 정보 입력
for _ in range(E):
  a, b, cost = map(int, input().split())
  # 비용 순 정렬을 위해 cost를 튜플의 첫번째 원소로 저장
  edges.append((cost, a, b))

# 비용 기준으로 오름차순으로 정렬
edges.sort()

# 특정 원소가 속한 집합을 찾는 함수
def find_parent(parent, x):
  # 루트 노드가 아니라면 루트 노드를 찾을 때까지 재귀 호출
  if parent[x] != x:
    parent[x] = find_parent(parent, parent[x])
  return parent[x]

# 두 원소가 속한 집합 합치기
def union_parent(parent, a, b):
  a = find_parent(parent, a)
  b = find_parent(parent, b)
  if a < b:
    parent[b] = a
  else:
    parent[a] = b

# 간선을 하나씩 확인한다
for cost, a, b in edges:
  if find_parent(parent, a) != find_parent(parent, b):
    union_parent(parent, a, b)
    result += cost

print(result)