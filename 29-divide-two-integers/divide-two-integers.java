class Solution {
    public int divide(int dividend, int divisor) {
        
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

    
        boolean negative = (dividend < 0) ^ (divisor < 0);

       
        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);

        int result = 0;

        for (int i = 31; i >= 0; i--) {
            if ((dvd >> i) >= dvs) {
                dvd -= (dvs << i);
                result += (1 << i);
            }
        }

        return negative ? -result : result;
    }
}
