class Solution {
    public void rotate(int[][] mat) {
        int n= mat.length;
        
        // Transpose matrix
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n;j++){
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }

        // reverse matrix

        for(int i=0; i < n; i++){
            int left = 0;
            int right = n-1;

            while(left < right){
                int temp = mat[i][left];
                mat[i][left] = mat[i][right];
                mat[i][right] = temp;

                left++;
                right--;
            }
        }


    }
}