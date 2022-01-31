class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> curr = new ArrayList<Integer>();
        Arrays.sort(candidates);
        int index = 0;
        int currSum = 0;
        backtracking(candidates, index, curr, currSum, target, res);
        return res;
    }
    
    public void backtracking(int[] candidates, int index, List<Integer> curr, int currSum, int target, List<List<Integer>> res) {
        if(currSum == target) {
            res.add(new ArrayList(curr));
            return;
        }
        for(int i = index; i < candidates.length; i++) {
            if(currSum+candidates[i] > target) {
                break;
            }
            curr.add(candidates[i]);
            backtracking(candidates, i, curr, currSum+candidates[i], target, res);
            curr.remove(curr.size()-1);
        }
    }
}
