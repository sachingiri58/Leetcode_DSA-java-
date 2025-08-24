class Solution {
    public int minimizeArrayValue(int[] nums) {
        int lo = 0, hi = 0;
        for (int x : nums) hi = Math.max(hi, x);

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (canLimit(nums, mid)) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }

    //  value <= limit?
    private boolean canLimit(int[] nums, int limit) {
        long carry = 0; // positive means  right
        for (int i = nums.length - 1; i >= 0; i--) {
            long val = nums[i] + carry;
            if (val > limit) {
                // push  left (i-1)
                carry = val - limit;
            } else {
         
                carry = 0;
            }
        }
        return carry == 0;
    }
}
