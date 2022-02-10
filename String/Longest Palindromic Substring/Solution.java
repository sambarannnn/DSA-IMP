class Solution {
    public String longestPalindrome(String s) {
        int left = 0;
        int right = -1;
        for(int i = 0; i < s.length(); i++) {
            int l = i;
            int r = i;
            while(l >= 0 && s.charAt(l) == s.charAt(i)) l--;
            while(r <= s.length()-1 && s.charAt(r) == s.charAt(i)) r++;
            
            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }
            l++;
            r--;
            int length = r-l+1;
            int currMaxLen = right-left+1;
            if(length > currMaxLen) {
                left = l;
                right = r;
            }
        }
        return s.substring(left, right+1);
    }
}
