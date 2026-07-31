class Solution {
    public void solveSudoku(char[][] board) {
        ArrayList<int[]> emptyList = new ArrayList<>();
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                if(board[i][j] == '.') {
                    emptyList.add(new int[]{i, j});
                }
            }
        }
        sudokuSolverHelper(0, emptyList, board);
    }

    public boolean sudokuSolverHelper(int idx, ArrayList<int[]> emptyList, char[][] board) {
        if(idx == emptyList.size()) return true;
        int[] rowCol = emptyList.get(idx);
        int r = rowCol[0];
        int c = rowCol[1];

        for (char d = '1'; d <= '9'; d++) {
            if(isSafe(d, r, c, board)) {
                board[r][c] = d;
                boolean ans = sudokuSolverHelper(idx+1, emptyList, board);
                if(ans == true)
                    return true;
                else
                    board[r][c] = '.';
            }
        }
        return false;
    }

    private boolean isSafe(char d, int r, int c, char[][] board) {
        for(int j=0; j<9; j++) {
            if(board[r][j] == d) return false;
        }
        for(int i=0; i<9; i++) {
            if(board[i][c] == d) return false;
        }
        int lRow = r/3; int lCol = c/3;

        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                if(board[lRow*3+i][lCol*3+j] == d) return false;
            }
        }
        return true;
    }
}