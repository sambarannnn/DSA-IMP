class Solution {
    public int lengthOfLIS(int[] nums) {
        //https://leetcode.com/problems/longest-increasing-subsequence/discuss/1326552/Optimization-From-Brute-Force-to-Dynamic-Programming-Explained!
        List<Integer> tailtable = new ArrayList<Integer>();
        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if(tailtable.size() == 0 || num > tailtable.get(tailtable.size()-1)) {//new max
                tailtable.add(num);
            } else {//we need to find first larger number which we will replace 
                int insertionIndex = bSearchFirstLarger(tailtable, num);
                tailtable.set(insertionIndex, num);
            }
        }
        return tailtable.size();
    }
    private static int bSearchFirstLarger(List<Integer> tailtable, int num) {
        int l = 0;
        int h = tailtable.size()-1;
        while(l <= h) {
            int mid = l + (h - l) / 2;
            if(tailtable.get(mid) >= num) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
