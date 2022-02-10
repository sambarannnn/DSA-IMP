class Solution {
    public String longestCommonPrefix(String[] strs) {
        //sort the strings alphabetically
        // String shortest = strs[0];
        // for(String str : strs) {
        //     if(str.length() < shortest.length()) {
        //         shortest = str;
        //     }
        // }
        // //shortest string is a candidate for longest common prefix
        // for(String str : strs) {
        //     while(!shortest.equals(str.substring(0, shortest.length()))) {
        //         //ensure curr_shortest can fit in beginning of current str
        //         shortest = shortest.substring(0, shortest.length()-1);
        //     }
        //     if(shortest.length() == 0)
        //         break;
        // }
        // return shortest;
        
        /*
        SORT THE ARRAY OF STRINGS
        ALPHABETICALLY AND LENGTHWISE ARRANGED
        now we have shortest and lexicographically first string at index 0
        and longest and lexicographically last string at index strs.length()-1
        longest possible answer is first string(0th index)
        so compare it with last string and keep dropping values
        */
        Arrays.sort(strs);
        String lcp = strs[0];
        String cmp = strs[strs.length-1];
        
        int index = 0;
        while(index < lcp.length()) {
            if(lcp.charAt(index) == cmp.charAt(index)) {
                index++;
            } else {
                break;
            }
        }
        return index == 0 ? "" : lcp.substring(0, index);
    }
}
