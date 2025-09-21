class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        // DP table
        int[][] dp = new int[m + 1][n + 1];

        // Base cases
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i; // deleting all characters from word1
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j; // inserting all characters into word1
        }

        // Fill DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    // If same character, no operation needed
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // If different, take min of insert, delete, replace
                    dp[i][j] = 1 + Math.min(
                        dp[i - 1][j],      // delete
                        Math.min(dp[i][j - 1], // insert
                                 dp[i - 1][j - 1]) // replace
                    );
                }
            }
        }

        return dp[m][n];
    }
}
