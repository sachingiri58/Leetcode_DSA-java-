class Solution {
    public int findShortestCycle(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        int ans = Integer.MAX_VALUE;
        for (int start = 0; start < n; start++) {
            int[] dist = new int[n];
            int[] parent = new int[n];
            Arrays.fill(dist, -1);
            Arrays.fill(parent, -1);

            Queue<Integer> q = new LinkedList<>();
            dist[start] = 0;
            q.offer(start);

            while (!q.isEmpty()) {
                int node = q.poll();
                for (int nei : graph.get(node)) {
                    if (dist[nei] == -1) {
                        dist[nei] = dist[node] + 1;
                        parent[nei] = node;
                        q.offer(nei);
                    } else if (parent[node] != nei) {
                        ans = Math.min(ans, dist[node] + dist[nei] + 1);
                    }
                }
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
