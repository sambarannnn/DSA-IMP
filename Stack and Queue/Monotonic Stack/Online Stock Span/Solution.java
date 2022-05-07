class StockSpanner {
    //use alternate version of nge
    //to calculate nge on left, we usually traverse from right end of array, this is alt code to traverse from left and still do it
    int index;
    Stack<Integer> stack;
    List<Integer> stocks;
    public StockSpanner() {
        index = 0;
        stack = new Stack<Integer>();
        stocks = new ArrayList<Integer>();
    }
    
    //think of this as individual iterations of a for loop
    public int next(int price) {
        stocks.add(price);
        while(!stack.isEmpty() && stocks.get(stack.peek()) <= price) {
            stack.pop();
        }
        //now stack.top should hold next greater element on left for price
        int res = -1;
        if(stack.isEmpty()) {//no nge on left
            res = index+1;
        } else {
            res = index - stack.peek(); 
        }
        stack.push(index);
        index++;
        return res;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
