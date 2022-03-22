class Solution {
    public String getSmallestString(int n, int k) {
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < n; i++) {
            res.append('a');
        }
        int currSum = 1 * n;//for n number of (a)s
        //now lets keep increasing terms from the end to match the sum
        int index = res.length()-1;
        while(currSum != k) {
            int remaining = k - currSum;
            if(remaining >= 25) {
                res.setCharAt(index, 'z');
                index--;
                currSum += 25;//since it already had 1 from 'a'
            } else {
                res.setCharAt(index, (char)(remaining+'a'));//find the char between a and z which satisfies this remaining sum
                index--;
                currSum += remaining;
            }
        }
        return res.toString();
    }
}
