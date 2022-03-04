class Point {

    int x;
    int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        Queue<Point> queue = new LinkedList<Point>();
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[i].length; j++) {
                if(mat[i][j] == 0) {
                    queue.add(new Point(i, j));
                } else {
                    mat[i][j] = -1;
                }
            }
        }
        while(!queue.isEmpty()) {
            Point curr = queue.remove();
            int r = curr.x;
            int c = curr.y;
            if(r >= 1 && mat[r-1][c] == -1) {
                queue.add(new Point(r-1, c));
                mat[r-1][c] = mat[r][c] + 1;
            }
            if(c >= 1 && mat[r][c-1] == -1) {
                queue.add(new Point(r, c-1));
                mat[r][c-1] = mat[r][c] + 1;
            }
            if(r <= mat.length-2 && mat[r+1][c] == -1) {
                queue.add(new Point(r+1, c));
                mat[r+1][c] = mat[r][c] + 1;
            }
            if(c <= mat[r].length-2 && mat[r][c+1] == -1) {
                queue.add(new Point(r, c+1));
                mat[r][c+1] = mat[r][c] + 1;
            }
        }
        return mat;
    }
}
