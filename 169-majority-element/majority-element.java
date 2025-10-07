public class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }

    // Optional: main method to test
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {3, 2, 3};
        System.out.println(sol.majorityElement(nums)); // Output: 3

        int[] nums2 = {2,2,1,1,1,2,2};
        System.out.println(sol.majorityElement(nums2)); // Output: 2
    }
}
