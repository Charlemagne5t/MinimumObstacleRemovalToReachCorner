import java.util.*;



class Solution {
    public int minimumObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Edge[][] g = new Edge[m * n][];
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                List<Edge> neighbors = new ArrayList<>();
                for (int[] d : directions) {
                    int nextI = i + d[0];
                    int nextJ = j + d[1];
                    if (nextI >= 0 && nextI < m && nextJ >= 0 && nextJ < n) {
                        neighbors.add(new Edge(grid[nextI][nextJ], nextI * n + nextJ));
                    }
                }
                g[i * n + j] = neighbors.toArray(new Edge[0]);
            }
        }

        int target = m * n - 1;


        PriorityQueue<Path> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.total));
        pq.offer(new Path(0, -1, grid[0][0]));

        int[] costs = new int[m * n];
        Arrays.fill(costs, Integer.MAX_VALUE);
        costs[0] = grid[0][0];

        while (!pq.isEmpty()) {
            Path cur = pq.poll();
            int curNode = cur.node;
            int curTotal = cur.total;

            if (curNode == target) {
                return curTotal;
            }
            if (curTotal > costs[curNode]) {
                continue;
            }

            costs[curNode] = curTotal;

            for (Edge e : g[curNode]) {
                if (e.toNode == cur.prev) {
                    continue;
                }
                int newCost = curTotal + e.cost;
                if (costs[e.toNode] > newCost) {
                    costs[e.toNode] = newCost;
                    pq.offer(new Path(e.toNode, curNode, newCost));
                }
            }
        }

        return -1;
    }
}

class Edge {
    int cost;
    int toNode;

    Edge(int cost, int toNode) {
        this.cost = cost;
        this.toNode = toNode;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "cost=" + cost +
                ", toNode=" + toNode +
                '}';
    }
}

class Path {
    int node;
    int prev;
    int total;

    Path(int node, int prev, int total) {
        this.node = node;
        this.prev = prev;
        this.total = total;
    }

    @Override
    public String toString() {
        return "Path{" +
                "node=" + node +
                ", prev=" + prev +
                ", total=" + total +
                '}';
    }
}
