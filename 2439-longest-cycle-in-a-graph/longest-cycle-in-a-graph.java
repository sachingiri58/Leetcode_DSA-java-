class Solution {
    public int longestCycle(int[] edges) {
        int n = edges.length;
        int longest = -1;
        int[] visited = new int[n]; 

        for (int i = 0; i < n; i++) {
            if (visited[i] != 0) continue;

            int node = i;
            Map<Integer, Integer> index = new HashMap<>();
            int step = 0;

            while (node != -1) {
                
                if (index.containsKey(node)) {
                    longest = Math.max(longest, step - index.get(node));
                    break;
                }
               
                if (visited[node] != 0) {
                    break;
                }

               
                index.put(node, step++);
                visited[node] = i + 1;
                node = edges[node];
            }
        }

        return longest;
    }
}
