class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        int index = 0;
        List<String> curr = new ArrayList<String>();
        
        backtracking(s, index, curr, res);
        return res;
    }
    public void backtracking(String s, int index, List<String> curr, List<List<String>> res) {
        if(index == s.length()) {
            res.add(new ArrayList(curr));
            return;
        }
        
        for(int i = index; i < s.length(); i++) {
            if(isPalindrome(s.substring(index, i+1))) {
                curr.add(s.substring(index, i+1));
                backtracking(s, i+1, curr, res);
                curr.remove(curr.size()-1);
            }
        }
    }
    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length()-1;
        while(l < r) {
            if(s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            } else {
                return false;
            }
        }
        return true;
    }
}
