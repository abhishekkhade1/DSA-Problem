class Solution {
    class Result{
        int ans=0;
    }

    public int totalNQueens(int n) {

        char[][] board = new char[n][n];

        for(int i = 0; i<n; i++){
            Arrays.fill(board[i], '.');
        }
        Result result = new Result();
        helper(board,0,n,result);
        return result.ans;

    }
    public void helper(char[][] board, int row, int n, Result res){

        if(row == n){
           res.ans++;
            return;
        }

        for(int j=0; j<n; j++){
            if(CanWePlaceQuens(j, row, board)){
                board[row][j] = 'Q';
                helper(board, row+1, n, res);
                board[row][j] = '.';
            }
        }
    }

    public boolean CanWePlaceQuens(int col, int row, char[][] board){
        // check column
        int n = board.length;

        for(int i=0; i<n; i++){
            if(board[i][col]=='Q') return false;
        }

        // check up-right diagonal
        for(int i=row-1, j=col-1 ; i>=0 && j>=0; i--,j--){
            if(board[i][j] =='Q') return false;
        }

        // check up left diagonal
        for(int i=row-1, j=col+1 ; i>=0 && j<n; i--,j++){
            if(board[i][j] =='Q') return false;
        }
        return true;
    }

}