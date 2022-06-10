class OrangePos {
    int x;
    int y;
    public OrangePos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        //BFS
        int totalOranges = 0;
        int rottenOranges = 0;
        int minutes = 0;
        
        Queue<OrangePos> queue = new LinkedList<OrangePos>();
        for(int i = 0; i <grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 2) {
                    queue.add(new OrangePos(i, j));
                    totalOranges++;
                } else if(grid[i][j] == 1) {
                    totalOranges++;
                }
            }
        }
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                OrangePos curr = queue.remove();
                rottenOranges++;
                int r = curr.x;
                int c = curr.y;
                if(r >= 1 && grid[r-1][c] == 1) {
                    queue.add(new OrangePos(r-1, c));
                    grid[r-1][c] = 2;
                }
                if(c >= 1 && grid[r][c-1] == 1) {
                    queue.add(new OrangePos(r, c-1));
                    grid[r][c-1] = 2;
                }
                if(r <= grid.length-2 && grid[r+1][c] == 1) {
                    queue.add(new OrangePos(r+1, c));
                    grid[r+1][c] = 2;
                }
                if(c <= grid[r].length-2 && grid[r][c+1] == 1) {
                    queue.add(new OrangePos(r, c+1));
                    grid[r][c+1] = 2;
                }
            }
            if(queue.size() > 0)
                minutes++;
        }
        return totalOranges == rottenOranges ? minutes : -1;
    }
}
