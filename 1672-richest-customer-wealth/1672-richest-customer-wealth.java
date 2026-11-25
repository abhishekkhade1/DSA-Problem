class Solution {
    public int maximumWealth(int[][] accounts) {
        int n = accounts.length;
        int m = accounts[0].length;

        int maxWealth = 0;
        for(int i=0; i<n; i++){
            int currWealth = 0;
            for(int j = 0;j<m; j++){
                currWealth += accounts[i][j];
                System.out.println(currWealth);
               
            }
             maxWealth = Math.max(maxWealth, currWealth);
        }
        return maxWealth;
    }
}