class Solution
{
    public int power(int num, int n, int m) {
        long ans = 1;
        for(int i = 1; i <= n; i++) {
            ans *= num;
            if(ans > m)
                return m+2;
        }
        return (int)ans;
    }
    public int NthRoot(int n, int m)
    {
        if (m == 1 || n == 1)
	        return m;
        // code here
        int l = 1;
        int r = m/n;
        
        while(l <= r) {
            int mid = l + (r-l)/2;
            int ans = power(mid, n, m);
            if(ans == m) {
                return mid;
            } else if(ans < m) {
                l = mid+1;
            } else {
                r = mid-1;
            }
        }
        return -1;
    }
}
