class Solution {
    public int splitArray(int[] nums, int m) {
        //IF M == NUMS.LENGTH, each element is a subarray, thus largest sum = max of all these elements
        //IF M == 1, only one subarray, thus largest sum = sum of array elements
        
        //find leftmost occurence of this sum which is valid in given array
        int low = Integer.MIN_VALUE;
        int high = 0;
        for(int num : nums) {
            low = Math.max(low, num);
            high += num;
        }
        
        while(low <= high) {
            int mid = low + (high-low)/2;
            if(isPossible(nums, m, mid)) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return low;
    }
    public static boolean isPossible(int[] nums, int max_containers, int max_sum) {
        int curr_sum = 0;
        int curr_containers = 1;
        
        for(int num : nums) {
            curr_sum += num;
            if(curr_sum > max_sum) {
                curr_containers++;
                curr_sum = num;
                if(curr_sum > max_sum || curr_containers > max_containers) {
                    return false;
                }
            }
        }
        return true;
    }
}
