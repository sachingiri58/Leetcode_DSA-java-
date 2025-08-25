class Solution {
    public long maxSumTrionic(int[] nums) {
        int n = nums.length;
        if (n < 3) return 0;

        long NEG = Long.MIN_VALUE / 4;

        // incEnd[i]: max sum of strictly increasing subarray (length ≥ 2) ending at i
        long[] incEnd = new long[n];
        Arrays.fill(incEnd, NEG);
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] < nums[i]) {
                long extend = incEnd[i - 1] == NEG ? NEG : incEnd[i - 1] + nums[i];
                long startNew = (long) nums[i - 1] + nums[i];
                incEnd[i] = Math.max(startNew, extend);
            }
        }

        // incStart[i]: max sum of strictly increasing subarray (length ≥ 2) starting at i
        long[] incStart = new long[n];
        Arrays.fill(incStart, NEG);
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                long extend = incStart[i + 1] == NEG ? NEG : incStart[i + 1] + nums[i];
                long startNew = (long) nums[i] + nums[i + 1];
                incStart[i] = Math.max(startNew, extend);
            }
        }

        long ans = NEG;
        int i = 1;
        while (i < n) {
            if (nums[i - 1] > nums[i]) {
                int p = i - 1;
                long decSum = nums[p];
                int j = i;
                while (j < n && nums[j - 1] > nums[j]) {
                    decSum += nums[j];
                    j++;
                }
                int q = j - 1;

                if (incEnd[p] != NEG && incStart[q] != NEG) {
                    long total = incEnd[p] + decSum + incStart[q] - nums[p] - nums[q];
                    ans = Math.max(ans, total);
                }
                i = j;
            } else {
                i++;
            }
        }

        return ans == NEG ? 0 : ans;
    }
}
