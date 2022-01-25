class Solution {
    public void rotate(int[][] a) {
        //transpose matrix
        //swap r-l
        
        for(int i = 0; i < a.length; i++) {
            for(int j = i + 1; j < a[i].length; j++) {
                int temp = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = temp;
            }
        }
        
        for(int i = 0; i < a.length; i++) {
            int l = 0;
            int r = a[i].length-1;
            while(l < r) {
                int temp = a[i][l];
                a[i][l] = a[i][r];
                a[i][r] = temp;
                l++;
                r--;
            }
        }
    }
}
