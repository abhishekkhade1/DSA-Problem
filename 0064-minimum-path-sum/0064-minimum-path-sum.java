class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] dp = new int[n+1][m+1];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                dp[i][j] = -1;
            }
        }

        return helper(0, 0, n, m, grid, dp);
        
    }
    public int helper(int i, int j,int n, int m,int[][] grid, int[][] dp){

        if(i==n-1 && j==m-1){
            return grid[i][j];
        }
        int right = Integer.MAX_VALUE;
        int down = Integer.MAX_VALUE;

        if(dp[i][j] != -1) return dp[i][j];

        if(j+1 < m)
            right = grid[i][j] + helper(i, j+1,n, m, grid, dp);

        if(i+1 < n) 
            down = grid[i][j] + helper(i+1, j, n, m, grid, dp);

         return dp[i][j] = Math.min(right, down);


    }
}