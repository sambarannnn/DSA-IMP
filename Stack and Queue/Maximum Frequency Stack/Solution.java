class FreqStack {
    List<Stack<Integer>> buckets;
    HashMap<Integer, Integer> freq_map;
    
    public FreqStack() {
        buckets = new ArrayList<Stack<Integer>>();
        freq_map = new HashMap<Integer, Integer>();
    }
    
    public void push(int val) {
        freq_map.put(val, freq_map.getOrDefault(val, 0) + 1);
        int currFreq = freq_map.get(val);
        if(currFreq-1 >= buckets.size()) {//list is 0 indexed
            buckets.add(new Stack<Integer>());
        }
        buckets.get(currFreq-1).add(val);//list is 0 indexed
    }
    
    public int pop() {
        int maxFreq = buckets.size();
        int val = buckets.get(maxFreq-1).pop();//list is 0 indexed
        if(buckets.get(maxFreq-1).size() == 0) {
            buckets.remove(maxFreq - 1);
        }
        freq_map.put(val, freq_map.get(val) - 1);
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
