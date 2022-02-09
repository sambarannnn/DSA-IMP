class StockSpanner {

    ArrayList<Integer> stocks;
    Stack<Integer> stack;
    int index;
    public StockSpanner() {
        stack = new Stack<Integer>();
        stocks = new ArrayList<Integer>();
        index = 0;
    }
    
    public int next(int price) {
        //keep finding nge on left
        stocks.add(price);
        while(!stack.isEmpty() && stocks.get(stack.peek()) <= price) {
            stack.pop();
        }
        int res = 1;
        if(stack.isEmpty()) {
            res = index+1;
        } else {
            res = index - (stack.peek()+1) + 1;
        }
        stack.push(index);
        index++;//for upcoming price
        return res;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
