class Solution {
    int median(int matrix[][], int r, int c) {
        // code here    
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < r; i++) {
            min = Math.min(matrix[i][0], min);
            max = Math.max(matrix[i][c-1], max);
        }
        
        
        //median should have tot/2 elements on left and tot/2 elements on right
        int reqd_smaller = (r*c)/2;
        //median is between max and min
        int low = min;
        int high = max;
        //find last occurence of of number with count_of_smaller = reqd_smaller
        //say for 1 2 3 3 6 6 6 9 9, median is 6(first occurence)
        //first mid will be 5, whose cout_smaller will be 4 which makes it a
        //legitimate candidate, but we move to the right still to find an
        //illegitimate candidate(7) with invalid count_smaller
        //so we move back and find 6 which is valid, so l = m+1 and l > r!!
        //6 is answer!
        //r is the reqd ans!!
        //say for 1 2 3 3 3 6 6 9 9, median is 3(last occurence)
        //mid = 5 will not satisy, so we move to left, 
        //mid = 2 wont satisfy so we move to right
        //mid = 3 will satisfy, so we move right again
        //mid = 4 will not satisfy so we move r back and r < l !!
        //so r is our ans i.e., 3!!
        while(low <= high) {
            int mid = low + (high-low)/2;
            int count_smaller = 0;
            count_smaller = BinaryFind(matrix, mid, r, c);//counts number of ele in matrix, smaller than this number
            if(count_smaller > reqd_smaller) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return high;//last element whose count is same than reqd
    }
    public static int BinaryFind(int[][] matrix, int num, int row, int c) {
        int count = 0;
        //find number of elements smaller than num
        //iterate rowwise and find index of first element of num
        for(int i = 0; i < row; i++) {
            int l = 0;
            int r = c-1;
            //find index of first element of num
            while(l <= r) {
                int mid = l + (r-l)/2;
                
                if(matrix[i][mid] < num) {
                    l = mid+1;
                } else {
                    r = mid-1;
                }
            }
            //l is location of first occurence of num
            count += l;//basically all numbers from index 0 to index l-1 are smaller
        }
        return count;
    }
}
