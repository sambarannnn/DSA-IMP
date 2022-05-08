class Solution {
    public int sumSubarrayMins(int[] arr) {
        //like largest histogram question
        //nle of left
        //nle on right
        //distance between nle on left and nle on right would give us the distance, this particular element is the minimum for
        //create all combinations for this distance and add it to the result
        
        Stack<Integer> stack = new Stack<Integer>();
        int[] nle_left = new int[arr.length];
        int[] nle_right = new int[arr.length];
        
        //nle_left
        for(int i = 0; i < arr.length; i++) {
            while(!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                nle_left[i] = -1;
            } else {
                nle_left[i] = stack.peek();
            }
            stack.push(i);
        }
        //nle_right
        stack.clear();
        for(int i = 0; i < arr.length; i++) {
            while(!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                nle_right[stack.pop()] = i;
            } 
            stack.push(i);
        }
        while(!stack.isEmpty()) {
            nle_right[stack.pop()] = arr.length;
        }
        
        int MOD = 1_000_000_007;
        long res = 0;
        for (int i = 0; i < arr.length; i++)  {
            long leftRange = (long)i - nle_left[i];
            long rightRange = nle_right[i] - (long)i;
            res = ( res + arr[i] * leftRange % MOD * rightRange % MOD ) % MOD;
        }
		return (int)res;
    }
}
