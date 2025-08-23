class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] delta = new int[n + 1];  

        
        for (int[] q : queries) {
            int l = q[0], r = q[1];
            delta[l] += 1;
            if (r + 1 < n) {
                delta[r + 1] -= 1;
            }
        }
        int running = 0;
        for (int i = 0; i < n; i++) {
            running += delta[i];
            if (running < nums[i]) {
                return false;  
            }
        }

        return true; 
    }
}
