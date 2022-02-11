class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int[] KMP = KMPprocessing(s);
        //length of longest substring = value of last index of KMP arr
        //chalk out abaabaabaaba and see
        int len_longest = KMP[s.length()-1];
        int len_shortest = s.length()-len_longest;
        return ((len_longest>0) && (s.length()%len_shortest == 0)) ? true : false;
    }
    private static int[] KMPprocessing(String s) {
        int[] KMP = new int[s.length()];
        int l = 0;
        int r = 1;
        while(r < s.length()) {
            if(s.charAt(l) == s.charAt(r)) {
                KMP[r] = l+1;
                l++;
                r++;
            } else {
                if(l > 0) {
                    l = KMP[l-1];
                } else {
                    KMP[r] = 0;
                    r++;
                }
            }
        }
        return KMP;
    }
}
