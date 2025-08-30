class Solution {
    private int count = 0;

    public int totalNQueens(int n) {
        boolean[] cols = new boolean[n];       // column occupied
        boolean[] diag1 = new boolean[2 * n]; // left diagonal (/)
        boolean[] diag2 = new boolean[2 * n]; // right diagonal (\)
        
        backtrack(0, n, cols, diag1, diag2);
        return count;
    }

    private void backtrack(int row, int n, boolean[] cols, boolean[] diag1, boolean[] diag2) {
        if (row == n) {
            count++;
            return;
        }
        for (int col = 0; col < n; col++) {
            int d1 = row - col + n;   // diagonal index for (/)
            int d2 = row + col;       // diagonal index for (\)
            
            if (cols[col] || diag1[d1] || diag2[d2]) continue; // not safe
            
            // place queen
            cols[col] = diag1[d1] = diag2[d2] = true;
            
            backtrack(row + 1, n, cols, diag1, diag2);
            
            // backtrack
            cols[col] = diag1[d1] = diag2[d2] = false;
        }
    }
}
