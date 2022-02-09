class Solution 
{
    //Function to find maximum of minimums of every window size.
    static int[] maxOfMin(int[] arr, int n) 
    {
        // Your code here
        Stack<Integer> s = new Stack<>();

        //using arrays to store previous and next smaller numbers.
        int[] l = leftSmaller(arr);
        int[] r = rightSmaller(arr);
        int[] res = new int[n];
        
        for(int i = 0; i < arr.length; i++) {
            int length = (r[i]-1)-(l[i]+1) +1; 
            res[length-1] = Math.max(res[length-1], arr[i]);
        }
        for(int i = n-2; i >= 0; i--) {
            res[i] = Math.max(res[i+1], res[i]);
        }
        return res;
    }
    static int[] leftSmaller(int[] arr) {
        int[] l = new int[arr.length];
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i < arr.length; i++) {
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                l[i] = -1;
            } else {
                l[i] = stack.peek();
            }
            stack.push(i);
        }
        return l;
    }
    static int[] rightSmaller(int[] arr) {
        int[] r = new int[arr.length];
        Arrays.fill(r, arr.length);
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = arr.length-1; i >= 0; i--) {
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                r[i] = arr.length;
            } else {
                r[i] = stack.peek();
            }
            stack.push(i);
        }
        return r;
    }
}
