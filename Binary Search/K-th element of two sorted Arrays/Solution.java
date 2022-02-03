class Solution {
    public long kthElement(int nums1[], int nums2[], int n, int m, int k) {
        int len1 = n;
        int len2 = m;
        if(len1 > len2) {
            //make sure nums1 has bigger length
            return kthElement(nums2, nums1, len2, len1, k);
        }
        int low = Math.max(0, k-m);//0 or min after selecting all from 2nd arr
        int high = Math.min(n, k);//all or just k
        
        while(low <= high) {
            int partitionX = low + (high-low)/2;
            int partitionY = k - partitionX;
            
            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX-1];
            int minRightX = (partitionX == len1) ? Integer.MAX_VALUE : nums1[partitionX];
            
            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minRightY = (partitionY == len2) ? Integer.MAX_VALUE : nums2[partitionY];
            
            if(maxLeftX <= minRightY && maxLeftY <= minRightX) {
                //we have found the correct partition
                return (Math.max(maxLeftX, maxLeftY));
            }
            if(maxLeftX > minRightY) {
                //we are too far on right side for partitionX. Go on left side.
                high = partitionX-1;
            } else {
                //we have too less in first array
                low = partitionX+1;
            }
        }
        //only if input wasnt sorted in the first place
        return 0;
    }
}
