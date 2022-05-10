class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        backtrack(1, new ArrayList<Integer>(), k, n, res);
        return res;
    }
    public void backtrack(int curr, List<Integer> list, int k, int n, List<List<Integer>> res) {
        if(list.size() == k) {
            if(n == 0)
                res.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i = curr; i <= 9; i++) {
            if(n-i < 0)
                break;
            list.add(i);
            backtrack(i+1, list, k, n-i, res);
            list.remove(list.size()-1);
        }
    }
}
