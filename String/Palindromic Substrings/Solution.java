class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            count += extend(s, i, i);//taking i as centre(odd length)
            count += extend(s, i, i+1); //even length
        }
        return count;
    }
    private static int extend(String s, int l, int r) {
        int count = 0;
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            count++;
            l--;
            r++;
        }
        return count;
    }
}
