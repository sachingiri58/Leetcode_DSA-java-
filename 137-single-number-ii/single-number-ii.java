class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        
        // Loop over each bit position
        for (int i = 0; i < 32; i++) {
            int sum = 0;

            // Sum up the i-th bits for all numbers
            for (int num : nums) {
                sum += (num >> i) & 1;
            }

            // Modulo 3 to isolate the unique number's bit
            if (sum % 3 != 0) {
                result |= (1 << i);
            }
        }

        // No need for special negative number handling
        return result;
    }
}
