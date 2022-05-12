class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);//to move over duplicates
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        backtrack(new ArrayList<Integer>(), new boolean[nums.length], nums, res);
        return res;
    }
    public void backtrack(List<Integer> curr, boolean[] visited, int[] nums, List<List<Integer>> res) {
        if(curr.size() == nums.length) {
            res.add(new ArrayList<Integer>(curr));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(visited[i]) {
                continue;
            } else {
                curr.add(nums[i]);
                visited[i] = true;
                backtrack(curr, visited, nums, res);
                visited[i] = false;
                curr.remove(curr.size()-1);
                while(i < nums.length-1 && nums[i+1] == nums[i]) {//skipping duplicates
                    i++;
                }
            }
        }
    }
}
