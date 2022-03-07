class Solution {
    public void sortColors(int[] nums) {
        int n0 = 0;
        int n1 = 0;
        int n2 = 0;
        for(int num : nums) {
            switch(num) {
                case 0 : n0++; break;
                case 1 : n1++; break;
                case 2 : n2++; break;
            }
        }
        int i = 0;
        while(n0-- > 0) nums[i++] = 0;
        while(n1-- > 0) nums[i++] = 1;
        while(n2-- > 0) nums[i++] = 2;
    }
}
