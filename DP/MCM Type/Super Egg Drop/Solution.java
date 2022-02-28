class Solution {
    Integer[][] memo = new Integer[101][10001];
    public int SLOWER_superEggDrop(int e, int n) {
        //LIKE MCM
        if(memo[e][n] != null) {
            return memo[e][n];
        }
        if(e == 1) {
            return memo[e][n] = n;
        }
        if(n == 1) {
            return memo[e][n] = 1;
        }
        int min = Integer.MAX_VALUE;
        for(int k = 1; k < n; k++) {
            int temp = 1 + Math.max(superEggDrop(e-1, k - 1), superEggDrop(e, n - k));
            min = Math.min(min, temp);
        }
        return memo[e][n] = min;
    }
    public int superEggDrop(int e, int n) {
        //FURTHER OPTOMISED
        if(memo[e][n] != null) {
            return memo[e][n];
        }
        if(e == 1) {
            return memo[e][n] = n;
        }
        if(n <= 1) {
            return memo[e][n] = n;
        }
        int min = Integer.MAX_VALUE;
        int l = 1;
        int r = n;
        while(l <= r) {
            int mid = l + (r-l) / 2;
            
            int downAttempts = superEggDrop(e-1, mid - 1);
            int upAttempts = superEggDrop(e, n - mid);
            int currWorstCase = 1 + Math.max(downAttempts, upAttempts);
            
            if(downAttempts > upAttempts) {
                r = mid-1;
            } else {
                l = mid+1;
            }
            min = Math.min(min, currWorstCase);
        }
        return memo[e][n] = min;
    }
}
