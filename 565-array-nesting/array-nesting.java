class Solution {
    public int arrayNesting(int[] nums) {
        int n = nums.length;
        boolean[] visited = new boolean[n];
        int res = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int start = i, count = 0;
                while (!visited[start]) {
                    visited[start] = true;
                    start = nums[start];
                    count++;
                }
                res = Math.max(res, count);
            }
        }
        return res;
    }
}
