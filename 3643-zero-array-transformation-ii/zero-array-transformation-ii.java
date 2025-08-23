class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        long[] diff = new long[n + 1];  // difference array
        long applied = 0;               // cumulative decrement applied so far
        int k = 0;                      // number of queries used

        for (int i = 0; i < n; i++) {
            // While nums[i] is still not zeroed out
            while (applied + diff[i] < nums[i]) {
                if (k >= queries.length) {
                    return -1;  // no more queries available
                }
                int l = queries[k][0];
                int r = queries[k][1];
                int val = queries[k][2];
                k++;

                // Skip if query does not cover this index
                if (r < i) {
                    continue;
                }

                // Apply difference array updates
                diff[Math.max(l, i)] += val;
                if (r + 1 < diff.length) {
                    diff[r + 1] -= val;
                }
            }
            applied += diff[i];  // accumulate applied decrements
        }

        return k;
    }
}
