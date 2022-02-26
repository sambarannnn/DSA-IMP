class Solution {
    public boolean isSubsequence(String s, String t) {
        //or can be done using lcs, if lcs of s and t equals s then s is a subsequence of t
        //or using this two pointer approach better time complexity here : O(m+n)
        int si = 0; 
        int ti = 0;
        
        while(si < s.length() && ti < t.length()) {
            if(s.charAt(si) == t.charAt(ti)) {
                si++;
                ti++;
            } else {
                ti++;
            }
        }
        if(si == s.length()) {
            return true;
        } else {
            return false;
        }
    }
}
