class Solution {
    public List<List<String>> solveNQueens(int n) {

        List<List<String>> ans = new ArrayList<>();

        char[][] board = new char[n][n];

        for(int i = 0; i< n; i++){
            Arrays.fill(board[i], '.');
        }

        helper(0, board, ans, n);
        return ans;

    }

    public static void helper(int row , char[][] board, List<List<String>> ans, int n){

        if(row == n){
            List<String> temp = new ArrayList<>();

            for(int i=0;i<n; i++){
                temp.add(new String(board[i]));
            }
            ans.add(temp);
            return;
        }


        for(int j=0; j<n; j++){

            if(canWePlaceQueen(row,j,board)){
                board[row][j]='Q';
                helper(row+1, board, ans, n);
                board[row][j] = '.';
            }
        }

    }
    public static boolean canWePlaceQueen(int row, int col, char[][] board){

        // check up
        int n = board.length;

        for(int i = row-1; i>=0; i-- ){
            if(board[i][col]=='Q') return false;
        }

        // check left
        for(int j = col-1; j>=0; j--){
            if(board[row][j] =='Q') return false;
        }

        // check left up diagonal

        for(int i=row-1 , j=col-1 ; i>=0 && j>=0; i--,j--){
            if(board[i][j]=='Q') return false;
        }

        // check right up diagonal
        for(int i=row-1 , j=col+1 ; i>=0 && j<n; i--,j++){
            if(board[i][j]=='Q') return false;
        }

        return true;
    }
}