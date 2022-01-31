class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int index = 0;
        List<Integer> curr = new ArrayList<Integer>();
        backtracking(nums, 0, curr, res);
        return res;
    }
    public void backtracking(int[] nums, int index, List<Integer> curr, List<List<Integer>> res) {
        if(index == nums.length) {
            res.add(new ArrayList(curr));
            return;
        }
        
        // include.add(nums[index]);
        curr.add(nums[index]);
        backtracking(nums, index+1, curr, res);
        
        //we dont pick this number, so we just pass on current
        curr.remove(curr.size() - 1);
        backtracking(nums, index+1, curr, res);
    }
}
