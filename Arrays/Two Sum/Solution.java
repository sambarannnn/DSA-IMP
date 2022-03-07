class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] nums2 = Arrays.copyOf(nums, nums.length);
        Arrays.sort(nums);
        int l = 0;
        int h = nums.length-1;
        int a = 0;
        int b = 0;
        while(l < h) {
            int ans = nums[l] + nums[h];
            if(ans == target) {
                // a = l;
                // b = h;
                break;
            } else if(ans > target) {
                h--;
            } else {
                l++;
            }
        }
        int res[] = new int[2];
        for(int i = 0; i < nums2.length; i++) {
            if(nums2[i] == nums[l]) {
                res[0] = i;
                break;
            }
        }
        if(nums[l] != nums[h]) {
            for(int i = 0; i < nums2.length; i++) {
            if(nums2[i] == nums[h]) {
                res[1] = i;
                }
            }
        } else {
            for(int i = 0; i < nums2.length; i++) {
                if(res[0] != i && nums2[i] == nums[h]) {
                    res[1] = i;
                    break;
                }
            }
        }
        return res;
        
    }
}
