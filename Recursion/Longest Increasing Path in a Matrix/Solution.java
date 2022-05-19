class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        Integer[][] memo = new Integer[matrix.length][matrix[0].length];
        int longest = Integer.MIN_VALUE;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                longest = Math.max(longest, findLongestPath(i, j, matrix, memo));
            }
        }
        return longest;
    }
    private static int findLongestPath(int r, int c, int[][] matrix, Integer[][] memo) {
        if(memo[r][c] != null) {
            return memo[r][c];
        }
        memo[r][c] = 1;//min distance from every cell is atleast 1
        int[][] dirs = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        for(int k = 0; k < 4; k++) {
            int[] dir = dirs[k];
            int x = r + dir[0];
            int y = c + dir[1];
            if(x >= 0 && y >= 0 && x <= matrix.length-1 && y <= matrix[r].length-1 && matrix[x][y] != -1 && matrix[x][y] > matrix[r][c]) {//possible path
                //checking for every direction
                memo[r][c] = Math.max(memo[r][c], 1+findLongestPath(x, y, matrix, memo));
            }
        }
        return memo[r][c];
    }
}
