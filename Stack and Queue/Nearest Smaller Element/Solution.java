public class Solution {
    public int[] prevSmaller(int[] A) {
        //TO THE LEFT
        int[] res = new int[A.length];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = A.length-1; i >= 0; i--) {
            while(!stack.isEmpty() && A[stack.peek()] > A[i]) {//when we get the smaller element, start popping
                res[stack.pop()] = A[i]; 
            }
            stack.push(i);//store in ascending order from right-left
        }
        return res;
    }
}
