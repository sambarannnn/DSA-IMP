class Solution {
    public int findDuplicate(int[] nums) {
        // return findDuplicateBinary(nums);
        int slow = nums[0];
        int fast = nums[0];
        //detect cycle
        while(fast != nums.length && nums[fast] != nums.length) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(slow == fast) {
                break;
            }
        }
        //find entrance to cycle
        slow = nums[0];
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
    public static int findDuplicateBinary(int[] nums) {
        //all numbers upto the repeated number will have (frequency of numbers <= number) = number
        //i.e., for [3,1,3,4,2]
        //frequency of nos <= 1 = 1 (1)
        //frequency of nos <= 2 = 2 (1, 2)
        //frequency of nos <= 3 = 4??? (1, 2, 3, 3) THIS SHOULD BE ONLY 3! (1, 2, 3)
        //frequency of nos <= 4 = 5!!! (1, 2, 3, 4) All nos after 3 will have an extra freq now
        //so we can binary search among the frequencies of entire search space to find the first occurence of this discrepancy
        //for one element in array that will be missing(because of duplicated value present), the frequency will come as 0
    
        int low = 1;
        int high = nums.length-1;
        
        while(low <= high) {
            int mid = low + (high - low) / 2;
            int freq = findLessOrEqualFreq(nums, mid);
            
            if(freq > mid) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
    public static int findLessOrEqualFreq(int[] nums, int mid) {
        int count = 0;
        for(int num : nums) {
            if(num <= mid) {
                count++;
            }
        }
        return count;
    }
}
