class Solution {
    public int singleNonDuplicate(int[] nums) {
        //first occurence is even index
        //next occurence is odd index
        //once single element occurs, we will break this pattern
        //single element will always occur in even index
        int low = 0;
        int high = nums.length-1;
    
        while(low <= high) {
            int mid = low+(high-low)/2;
            if(mid%2 == 0) {
                if(mid<nums.length-1 && nums[mid] == nums[mid+1]) {//pattern is valid till here, search ahead
                    low = mid+1;
                } else {
                    high = mid-1;//pattern already invalidated move behind
                    //when single is found at even index, will continue to decrement high until l > h
                }
            } else {
                if(nums[mid] == nums[mid-1]) {//pattern still valid//no need to put mid-1 check as 0th index will be even and will be handled above
                    low = mid+1;
                } else {
                    high = mid-1;
                }
            }
        }
        return nums[low];
    }
}
