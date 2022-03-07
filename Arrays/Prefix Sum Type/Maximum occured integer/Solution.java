class Solution{
    //Function to find the maximum occurred integer in all ranges.
    public static int maxOccured(int L[], int R[], int n, int maxx){
        //treat it like prefix sum array
        int[] freq = new int[maxx+2];
        for(int i = 0; i < n; i++) {
            freq[L[i]]++;
            freq[R[i]+1]--;
        }
        int maxOccur = Integer.MIN_VALUE;
        int max_freq = Integer.MIN_VALUE;
        
        int curr = 0;
        for(int f = 0; f < freq.length; f++) {
           curr += freq[f];
           if(curr > max_freq) {
               max_freq = curr;
               maxOccur = f;
           }
        }
        return maxOccur;
    }
    
}
