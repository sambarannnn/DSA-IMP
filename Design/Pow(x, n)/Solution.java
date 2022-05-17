class Solution {
    public double myPow(double x, int n) {
        if(n < 0) {
            n = -(n+1);
            return ((1/x) * (1/power(x, n)));
        }
        return power(x, n);
    }
    
    public double power(double x, int n) {
        if(n == 0)
            return 1;
        if(n == 1)
            return x;
        
        if(n % 2 == 0) {
            double res = power(x, n/2);
            return res * res;
        } else {
            return x * power(x, n-1);
        }
    }
}
