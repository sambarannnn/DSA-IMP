class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        String[] mapping = new String[] {
                    "0", 
            "1", "abc", "def", 
            "ghi", "jkl", "mno", 
            "pqrs", "tuv", "wxyz"
        };
        if(digits.length()==0) {
            return res;
        }
        backtrack(0, new StringBuilder(), digits, res, mapping);
        return res;
    }
    public void backtrack(int curr, StringBuilder str, String digits, List<String> res, String[] mapping) {
        if(curr == digits.length()) {
            res.add(new String(str));
            return;
        }
        int num = digits.charAt(curr)-'0';
        String letters = mapping[num];
        for(int i = 0; i < letters.length(); i++) {
            str.append(letters.charAt(i));
            backtrack(curr+1, str, digits, res, mapping);
            str.deleteCharAt(str.length()-1);
        }
    }
}
