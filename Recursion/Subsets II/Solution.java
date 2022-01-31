class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
      List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int index = 0;
        List<Integer> curr = new ArrayList<Integer>();
        backtracking(nums, 0, curr, res);
        return res;
    }
    public void backtracking(int[] nums, int index, List<Integer> curr, List<List<Integer>> res) {
        res.add(new ArrayList<Integer>(curr));
        
        for(int i = index; i < nums.length; i++) {
            if(i > index && nums[i] == nums[i-1]) {
                continue;
            }
            curr.add(nums[i]);
            backtracking(nums, i+1, curr, res);
            curr.remove(curr.size()-1);
        }
    }
}
