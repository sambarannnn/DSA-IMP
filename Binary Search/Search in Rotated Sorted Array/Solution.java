class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int h = nums.length-1;
        
        while(l <= h) {
            int m = l + (h-l)/2;
            
            int mid = nums[m];
            int low = nums[l];
            int high = nums[h];
            
            if(mid == target) {
                return m;
            }
            if(low <= mid) {//left side is sorted
                if(target < mid && target >= low) {//lies in sorted left half
                    h = m-1;
                } else {
                    l = m+1;
                }
            } else {//right side is sorted
                if(target > mid && target <= high) {//lies in sorted right half
                    l = m+1;
                } else {
                    h = m-1;
                }
            }
        }
        return -1;
    }
}
