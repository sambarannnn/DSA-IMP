class Solution {
    public void gameOfLife(int[][] board) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                int lvcnt = count(board, i, j);
                // System.out.print(lvcnt + " ");
                if(board[i][j] == 1) {
                    if(lvcnt < 2 || lvcnt > 3) {
                        board[i][j] = -1;//kill it with dummy value but still treat as ALIVE
                    }
                } else {
                    if(lvcnt == 3) {
                        board[i][j] = 5;//revive it with dummy value but still treat as DEAD
                    }
                }
            }
            // System.out.println();
        }
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(board[i][j] == -1) {
                    board[i][j] = 0;
                } else if(board[i][j] == 5) {
                    board[i][j] = 1;
                }
            }
        }
    }
    public int count(int[][] board, int r, int c) {
        int count = 0;
        if(r > 0 && (board[r-1][c] == 1 || board[r-1][c] == -1)) {
            count++;
        }
        if(r > 0 && c > 0 && (board[r-1][c-1] == 1 || board[r-1][c-1] == -1)) {
            count++;
        }
        if(r > 0 && c < board[r].length-1 && (board[r-1][c+1] == 1 || board[r-1][c+1] == -1)) {
            count++;
        }
        
        if(r < board.length-1 && (board[r+1][c] == 1 || board[r+1][c] == -1)) {
            count++;
        }
        if(r < board.length-1 && c > 0 && (board[r+1][c-1] == 1 || board[r+1][c-1] == -1)) {
            count++;
        }
        if(r < board.length-1 && c < board[r].length-1 && (board[r+1][c+1] == 1 || board[r+1][c+1] == -1)) {
            count++;
        }
        
        if(c > 0 && (board[r][c-1] == 1 || board[r][c-1] == -1)) {
            count++;
        }
        if(c < board[r].length-1 && (board[r][c+1] == 1 || board[r][c+1] == -1)) {
            count++;
        }
        
        
        return count;
    }
}
