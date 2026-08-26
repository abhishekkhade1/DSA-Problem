class Solution {
    public int uniquePaths(int m, int n) {
        int[][] memo = new int[m][n];

        for(int[] row : memo)
        Arrays.fill(row, -1);

        return helper(0, 0, m, n, memo);
    }
    public int helper(int i, int j, int m, int n, int[][] memo){

        if(i == m-1) return 1;
        if(j == n-1) return 1;

        if (i >= m || j >= n) {
            return 0;
        }

        if(memo[i][j]!= -1){
            return memo[i][j];
        }

        int right = helper(i+1, j, m, n, memo); 
        int down = helper(i, j+1, m, n, memo);

        memo[i][j] = right + down;

        return memo[i][j];
    }

}