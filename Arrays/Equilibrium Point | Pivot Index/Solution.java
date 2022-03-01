class Solution {

    
    // a: input array
    // n: size of array
    // Function to find equilibrium point in the array.
    public static int equilibriumPoint(long arr[], int n) {

        // Your code here
        long sum = 0;
        for(long num : arr) {
            sum += num;
        }
        long leftSum = 0;
        long rightSum = sum;
        for(int i = 0; i < n; i++) {
            rightSum -= arr[i];
            if(leftSum == rightSum) {
                return i + 1;
            }
            leftSum += arr[i];
        }
        return -1;
    }
}
