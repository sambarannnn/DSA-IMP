class Solution{
    static int countWays(int N, String S){
        // code here
        Integer[][][] memo = new Integer[201][201][2];
        return countWays(S, 0, S.length()-1, true, memo);
    }
    public static int countWays(String s, int i, int j, boolean isTrue, Integer[][][] memo) {
        
        int t_index = 0;
        if(isTrue == true) {
            t_index = 1;
        }
        if(memo[i][j][t_index] != null) {
            return memo[i][j][t_index];
        }
        if(i == j) {
            if(isTrue == true) {
                if(s.charAt(i) == 'T') {
                    return memo[i][j][t_index] = 1;
                } else {
                    return memo[i][j][t_index] = 0;
                }
            } else {
                if(s.charAt(i) == 'F') {
                    return memo[i][j][t_index] = 1;
                } else {
                    return memo[i][j][t_index] = 0;
                }
            }
        }
        int mod = 1003;
        long ways = 0;
        for(int k = i + 1; k <= j-1; k += 2) {
            int lt = countWays(s, i, k-1, true, memo);
            int lf = countWays(s, i, k-1, false, memo);
            int rt = countWays(s, k+1, j, true, memo);
            int rf = countWays(s, k+1, j, false, memo);
            switch(s.charAt(k)) {
                case '&' :
                    if(isTrue) {
                        ways += (lt * rt);
                    } else {
                        ways += (lt * rf) + (lf * rt) + (lf * rf);
                    }
                    break;
                case '|' :
                    if(isTrue) {
                        ways += (lf * rt)+ (lt * rf) + (lt * rt);
                    } else {
                        ways += (lf * rf);
                    }
                    break;
                case '^' :
                    if(isTrue) {
                        ways += (lt * rf) + (lf * rt);
                    } else {
                        ways += (lt * rt) + (lf * rf);
                    }
                    break;
            }
        }
        return memo[i][j][t_index] = (int)((ways) % mod);
    }
}
