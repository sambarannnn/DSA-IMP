class Solution {
    public int orangesRotting(int[][] grid) {
        int countOranges = 0;
        Queue<int[]> queue = new LinkedList<int[]>();
        
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
                if(grid[i][j] != 0) {
                    countOranges++;
                }
            }
        }
        
        int rottenCount = queue.size();
        int minuteCount = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int[] rottenOrange = queue.remove();
                int x = rottenOrange[0];
                int y = rottenOrange[1];
                
                if(x + 1 <= grid.length-1 && grid[x+1][y] == 1) {
                    grid[x+1][y] = 2;
                    queue.add(new int[]{x+1, y});
                }
                if(y + 1 <= grid[x].length-1 && grid[x][y+1] == 1) {
                    grid[x][y+1] = 2;
                    queue.add(new int[]{x, y+1});
                }
                if(x - 1 >= 0 && grid[x-1][y] == 1) {
                    grid[x-1][y] = 2;
                    queue.add(new int[]{x-1, y});
                }
                if(y - 1 >= 0 && grid[x][y-1] == 1) {
                    grid[x][y-1] = 2;
                    queue.add(new int[]{x, y-1});
                }
            }
            if(queue.size() > 0)//if we infected any more oranges, it took us one minute
                minuteCount++;
            rottenCount += queue.size();
        }
        return rottenCount == countOranges ? minuteCount : -1;
    }
}
