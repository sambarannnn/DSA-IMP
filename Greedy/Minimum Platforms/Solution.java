class Solution
{
    //Function to find the minimum number of platforms required at the
    //railway station such that no train waits.
    static int findPlatform(int arr[], int dep[], int n)
    {
        // add your code here
        Arrays.sort(arr);
        Arrays.sort(dep);
        int max = Integer.MIN_VALUE;
        int curr = 0;
        int i = 0; 
        int j = 0;
        
        while(i < n && j < n) {
            if(arr[i] <= dep[j]) {//even if arr and dep is same, we need one more platform
                curr++;
                i++;
                max = Math.max(max, curr);
            } else {
                j++;
                curr--;
            }
        }
        //max is the max number of trains in the station at a time
        //thus, max no of trains at a time is the min no of required platforms
        return max;
    }
    
}
