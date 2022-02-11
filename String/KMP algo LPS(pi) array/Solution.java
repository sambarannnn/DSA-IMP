class Solution {
    public int strStr(String haystack, String needle) {
        //https://leetcode.com/problems/implement-strstr/discuss/13024/O(m%2Bn)-and-O(mn)-solutions
        String text = haystack;
        String pattern = needle;
        int[] KMP = KMPpreprocess(needle);
        int i = 0;
        int j = 0;
        while(i < text.length() && j < pattern.length()) {
            if(text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else {
                if(j > 0) {
                    j = KMP[j-1];
                } else {
                    i++;
                } 
            }
        }
        if(j == pattern.length()) {
            return i - j;
        } else {
            return -1;
        }
    }
    public int[] KMPpreprocess(String pattern) {
        int[] KMP = new int[pattern.length()];
        int l = 0;
        int r = 1;
        
        while(r < pattern.length()) {
            if(pattern.charAt(l) == pattern.charAt(r)) {
                KMP[r] = l+1;
                l++;
                r++;
            } else {
                if(l > 0) {
                    l = KMP[l-1];
                } else {//l becomes 0
                    KMP[r] = 0;
                    r++;
                }
            }
        }
        return KMP;
    }
}
