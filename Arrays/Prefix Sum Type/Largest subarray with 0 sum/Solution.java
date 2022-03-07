class GfG
{
    int maxLen(int arr[], int n)
    {
        // Your code here
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        
        for(int i = 0; i < n; i++) {
            int num = arr[i];
            sum += num;
            if(map.containsKey(sum)) {
                max = Math.max(max, i-map.get(sum));
            }
            else if(sum == 0) {
                max = Math.max(max, i+1);
            }
            else
                map.put(sum, i);
            }
        return max;
    }
}
