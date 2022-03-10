class Solution {
    public static int sum(int n) {
        int sum = 0;
        while(n != 0) {
            sum += (n%10) * (n%10);
            n /= 10;
        }
        return sum;
    }
    public boolean isHappy(int n) {
        //SAME AS FINDING CYCLE IN LINKED LIST USING FLOYDS CYCLE DETECTION ALGORITHM
        int slow = n;
        int fast = n;
        while(fast != 1 && sum(fast) != 1) {
            slow = sum(slow);
            fast = sum(sum(fast));
            if(slow == fast) {
                return false;
            }
        }
        return true;
    }
}
