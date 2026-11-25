class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int[][] ans = new int[r][c];
        int n = mat.length;
        int m = mat[0].length;

        if(n*m != r*c){
            return mat;
        }

        for(int i=0; i<r*c; i++){
            ans[i/c][i%c] = mat[i/m][i%m];
        }

        return ans;

    
    }
}