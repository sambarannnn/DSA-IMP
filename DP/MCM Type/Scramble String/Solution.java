class Solution {
    public static HashMap<String, Boolean> memo = new HashMap<String, Boolean>(); 
    public boolean isScramble(String s1, String s2) {
        if(s1.length() != s2.length()) {
            return false;
        }
        String key = s1+" "+s2;
        if(memo.containsKey(key)) {
            return memo.get(key);
        }
        if(s1.equals(s2)) {
            memo.put(key, true);
            return true;
        }
        if(s1.length() == 1) {//if both are at one char each and still not equal
            memo.put(key, false);
            return false;
        }
        int len = s1.length();
        for(int k = 1; k <= len-1; k++) {
            if(((isScramble(s1.substring(0, k), s2.substring(0, k)) && isScramble(s1.substring(k), s2.substring(k))) ||
                (isScramble(s1.substring(0, k), s2.substring(len-k)) && isScramble(s1.substring(k), s2.substring(0, len-k)))
                )== true) {
                memo.put(key, true);
                return true;
            }
        }
        memo.put(key, false);
        return false;
    }
}
