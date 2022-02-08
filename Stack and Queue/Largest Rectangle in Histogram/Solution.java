class Solution {
    public int largestRectangleArea(int[] heights) {
        //find nge for each on both sides
        int n = heights.length;
        int[] l = new int[n];
        int[] r = new int[n];
        Stack<Integer> stack = new Stack<Integer>();
        //find limit on left
        for(int i = 0; i < n; i++) {
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                l[i] = 0;
            } else {
                l[i] = stack.peek()+1;
            }
            stack.push(i);
        }
        stack.clear();
        
        for(int i = n-1; i >= 0; i--) {
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                r[i] = n-1;
            } else
                r[i] = stack.peek()-1;
            stack.push(i);
        }
        int max_area = 0;
        for(int i = 0; i < n; i++) {
            // System.out.println(l[i] + " | " +  heights[i] + " | " + r[i]);
            max_area = Math.max(max_area, heights[i]*(r[i]-l[i]+1));
        }
        return max_area;
    }
}
