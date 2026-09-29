
class Solution {
    Boolean[][][] dp;

    public boolean hasValidPath(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // A valid parentheses string must have even length.
        if ((m + n) % 2 == 0) {
            return false;
        }

        dp = new Boolean[m][n][m + n + 1];

        return dfs(grid, 0, 0, 0);
    }

    private boolean dfs(char[][] grid, int i, int j, int balance) {
        int m = grid.length;
        int n = grid[0].length;

        // Update balance using current cell.
        if (grid[i][j] == '(') {
            balance++;
        } else {
            balance--;
        }

        // Balance can never be negative.
        if (balance < 0) {
            return false;
        }

        // Too many opening brackets to close with remaining cells.
        int remaining = (m - 1 - i) + (n - 1 - j);
        if (balance > remaining) {
            return false;
        }

        // Destination reached.
        if (i == m - 1 && j == n - 1) {
            return balance == 0;
        }

        if (dp[i][j][balance] != null) {
            return dp[i][j][balance];
        }

        boolean down = false;
        boolean right = false;

        if (i + 1 < m) {
            down = dfs(grid, i + 1, j, balance);
        }

        if (j + 1 < n) {
            right = dfs(grid, i, j + 1, balance);
        }

        return dp[i][j][balance] = down || right;
    }
}