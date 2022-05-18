class Solution {
    public int longestPalindrome(String s) {
        HashSet<Character> set = new HashSet<Character>();//to hold unpaired chars
        for(char c : s.toCharArray()) {
            if(set.contains(c)) {//found a pair
                set.remove(c);//remove first part of the pair
            } else {
                set.add(c);//wait for a pair
            }
        }
        int unpaired = set.size();
        if(unpaired == 0) {
            return s.length();//everyone has a pair
        } else {
            int paired = s.length() - unpaired;
            return paired + 1;//adding 1 for the middle element which can be unpaired
        }
    }
}
