class Solution {
    public int repeatedStringMatch(String a, String b) {
        StringBuilder expanded_a = new StringBuilder(a);
        int count = 1;
        while(expanded_a.length() < b.length()) {
            expanded_a.append(a);
            count++;
        }
        //now, it should satisfy for count or count+1
        if(isPossible(expanded_a.toString(), b)) {
            return count;
        }
        expanded_a.append(a);
        count += 1;
        return isPossible(expanded_a.toString(), b) ? count : -1;
    }
    public static boolean isPossible(String big, String small) {
        
        for(int i = 0; i < big.length()-small.length()+1; i++) {
            for(int j = 0; j < small.length(); j++) {
                if(big.charAt(i+j) != small.charAt(j)) {
                    break;
                }
                if(j == small.length()-1)
                    return true;
            }
        }
        return false;
    }
}
