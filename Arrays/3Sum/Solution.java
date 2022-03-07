class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums.length < 3)
            return res;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            int low = i + 1;
            int high = nums.length-1;
            int target = 0-nums[i];
            while(low < high) {
                int num = nums[low] + nums[high];
                if(num == target) {
                    res.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[low], nums[high])));
                    while(low < high && nums[low+1] == nums[low]) low++;
                    while(low < high && nums[high-1] == nums[high]) high--;
                    low++;
                    high--;
                } else if(num < target){
                    low++;
                } else {
                    high--;
                }
            }
            while(i < nums.length-1 && nums[i+1] == nums[i]) i++;
        }
        return res;
    }
}
