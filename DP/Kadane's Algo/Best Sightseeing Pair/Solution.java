class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int currMax = values[0] + 0;
        int res = 0;
        for(int i = 1; i < values.length; i++) {
            res = Math.max(res, currMax + values[i] - i);
            currMax = Math.max(currMax, values[i] + i);
        }
        return res;
    }
}
