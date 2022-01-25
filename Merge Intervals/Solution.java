class Solution {
    public int[][] merge(int[][] intervals) {
        
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        Stack<int[]> res = new Stack<int[]>();
        res.add(intervals[0]);
        for(int i = 1; i < intervals.length; i++) {
            
            if(res.peek()[1] >= intervals[i][0]) {
                res.peek()[1] = Math.max(intervals[i][1], res.peek()[1]);
                
            } else {
                res.add(intervals[i]);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
