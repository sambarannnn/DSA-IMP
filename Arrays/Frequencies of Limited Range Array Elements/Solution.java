class Solution{
    //Function to count the frequency of all elements from 1 to N in the array.
    public static void frequencyCount(int arr[], int n, int P) {
        // code here
        //the array indexes lie between 0 and N-1
        //the elements lie between 1 and P
        //but we have to ignore elements greater than N
        //so essentially, all elements are between 1 and N
        
        int expectedPos = 0;
        int pos = 0;
        while(pos < n) {
            if(arr[pos] > n) {
                arr[pos] = 0;
                pos++;
                continue;
            }
            expectedPos = arr[pos] - 1;
            if(arr[pos] > 0 && arr[expectedPos] > 0) {
                arr[pos] = arr[expectedPos];
                arr[expectedPos] = -1;
            } else if(arr[pos] > 0 && arr[expectedPos] <= 0) {
                arr[expectedPos]--;
                arr[pos] = 0;
                pos++;
            } else if(arr[pos] <= 0) {
                pos++;
            }
        }
        for(int i = 0; i < n; i++) {
            arr[i] = Math.abs(arr[i]);
        }
    }
}
