class Solution {
    public int[][] transpose(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] mat = new int[m][n];
        
        for(int i=0; i < n; i++){
            for(int j=0; j < m; j++){
                mat[j][i] = matrix[i][j];
            }
        }
        return mat;
    }
}


// class Solution {
//     public int[][] transpose(int[][] matrix) {
//         int m = matrix.length;
//         int n = matrix[0].length;

//         int[][] ans = new int[n][m];

//         for (int i = 0; i < m; i++) {
//             for (int j = 0; j < n; j++) {
//                 ans[j][i] = matrix[i][j];
//             }
//         }

//         return ans;
//     }
// }
