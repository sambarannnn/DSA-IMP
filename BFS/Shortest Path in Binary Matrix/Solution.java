class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        //for shortest path, do bfs
        //from top left cell, explore all possible paths at each level until you find bottom right corner
        //when you find bottom right corner, you can find the current level to be the shortest path
        int[][] dirs = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        int m = grid.length;
        int n = grid[m-1].length;
        if(grid[0][0] != 0 || grid[m-1][n-1] != 0) {
            return -1;
        }
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.add(new int[]{0, 0});
        grid[0][0] = 2;//mark as visited
        int level = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for(int i = 0; i < size; i++) {
                int[] curr = queue.remove();
                if(curr[0] == m-1 && curr[1] == n-1) {//reached bottom right corner at this level
                    return level;
                }
                for(int k = 0; k < 8; k++) {
                    int[] dir = dirs[k];
                    int x = curr[0] + dir[0];
                    int y = curr[1] + dir[1];
                    
                    if(x >= 0 && y >= 0 && x <= m-1 && y <= n-1 && grid[x][y] == 0) {//possible path
                        grid[x][y] = 2;//mark as visited
                        queue.add(new int[]{x, y});
                    }
                }
            }
        }
        return -1;//in case we dont stumble upon bottom right corner
    }
}
