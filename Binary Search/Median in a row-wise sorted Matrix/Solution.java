class Solution {
    int median(int matrix[][], int r, int c) {
        // code here    
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < r; i++) {
            min = Math.min(matrix[i][0], min);
            max = Math.max(matrix[i][c-1], max);
        }
        //median is between max and min
        
        //median should have tot/2 elements on left and tot/2 elements on right
        int reqd_smaller = (r*c)/2;
        //find last occurence of of number with count_of_smaller = reqd_smaller
        while(min <= max) {
            int mid = min + (max-min)/2;
            int count_smaller = 0;
            count_smaller = BinaryFind(matrix, mid, r, c);//counts number of ele in matrix, smaller than this number
            if(count_smaller > reqd_smaller) {
                max = mid-1;
            } else {
                min = mid+1;
            }
        }
        return max;//last element whose count is same than reqd
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
