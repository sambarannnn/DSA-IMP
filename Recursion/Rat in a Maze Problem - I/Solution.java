// m is the given matrix and n is the order of matrix
class Solution {
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        ArrayList<String> res = new ArrayList<String>();
        int curr_row = 0;
        int curr_col = 0;
        StringBuilder curr = new StringBuilder();
        solve(m, curr_row, curr_col, curr, res);
        return res;
    }
    public static void solve(int[][] m, int curr_row, int curr_col, StringBuilder curr, ArrayList<String> res) {
        if(m[curr_row][curr_col] == 0) {
            return;
        }
        if(curr_row == m.length-1 && curr_col == m[curr_row].length-1) {
            res.add(curr.toString());
            // System.out.println(res);
            return;
        }
        m[curr_row][curr_col] = 0;
        // System.out.println(curr_row + " " + curr_col);
        if(curr_row > 0) {
            curr.append("U");
            solve(m, curr_row-1, curr_col, curr, res);
            curr.deleteCharAt(curr.length()-1);
        }
        if(curr_col > 0) {
            curr.append("L");
            solve(m, curr_row, curr_col-1, curr, res);
            curr.deleteCharAt(curr.length()-1);
        }
        if(curr_row < m.length-1) {
            curr.append("D");
            solve(m, curr_row+1, curr_col, curr, res);
            curr.deleteCharAt(curr.length()-1);
        }
        if(curr_col < m[curr_row].length-1) {
            curr.append("R");
            solve(m, curr_row, curr_col+1, curr, res);
            curr.deleteCharAt(curr.length()-1);
        }
        m[curr_row][curr_col] = 1;
    }
}
