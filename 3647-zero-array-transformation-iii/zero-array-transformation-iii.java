class Solution {
    public int maxRemoval(int[] nums, int[][] queries) {
        int n = nums.length;
        int q = queries.length;
       
        Arrays.sort(queries, (a, b) -> Integer.compare(a[0], b[0]));

        // Max-heap 
        PriorityQueue<Integer> available = new PriorityQueue<>(Collections.reverseOrder());
        // Min-heap 
        PriorityQueue<Integer> running = new PriorityQueue<>();

        int queryIndex = 0;

        for (int i = 0; i < n; i++) {
           
            while (queryIndex < q && queries[queryIndex][0] <= i) {
                available.offer(queries[queryIndex][1]);
                queryIndex++;
            }
           
            while (!running.isEmpty() && running.peek() < i) {
                running.poll();
            }
            
            while (running.size() < nums[i]) {
                if (available.isEmpty() || available.peek() < i) {
                    return -1;
                }
                running.offer(available.poll());
            }
        }
      
        return available.size();
    }
}
