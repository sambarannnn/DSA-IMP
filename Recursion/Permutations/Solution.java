class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> curr = new ArrayList<Integer>();
        boolean[] visited = new boolean[nums.length];
        //can also mark nums ele as -11 or 11 to mark visited since -10 <= nums[i] <= 10  
        backtracking(nums, curr, visited, res);
        return res;
    }
    public void backtracking(int[] nums, List<Integer> curr, boolean[] visited, List<List<Integer>>res) {
        if(curr.size() == nums.length) {
            res.add(new ArrayList<Integer>(curr));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(!visited[i]) {
                curr.add(nums[i]);
                visited[i] = true;
                backtracking(nums, curr, visited, res);
                curr.remove(curr.size()-1);
                visited[i] = false;
            }
        }
    }
}
