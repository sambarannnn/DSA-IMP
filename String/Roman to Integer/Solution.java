class Solution {
    public int romanToInt(String s) {
        int res = 0;
        HashMap<Character, Integer> roman = new HashMap<Character, Integer>();
        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);
        for(int i = s.length()-1; i >= 0; i--) {
            char curr = s.charAt(i);
            if(i <= s.length()-2 && roman.get(s.charAt(i)) < roman.get(s.charAt(i+1))) {
                res -= roman.get(s.charAt(i));
            } else {
                res += roman.get(s.charAt(i));
            }
        }
        return res;
    }
}
